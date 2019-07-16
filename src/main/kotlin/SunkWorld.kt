@file:Suppress("DEPRECATION")

package flavor.pie.sunkcost

import com.flowpowered.math.vector.Vector3i
import flavor.pie.kludge.*
import flavor.pie.sunkcost.block.biome
import flavor.pie.sunkcost.block.biomeType
import flavor.pie.sunkcost.entity.SunkEntity
import flavor.pie.sunkcost.entity.entityType
import flavor.pie.sunkcost.entity.sEntityType
import flavor.pie.sunkcost.inventory.SunkItemStack
import flavor.pie.sunkcost.listeners.WorldListener
import flavor.pie.sunkcost.material.toBlockState
import flavor.pie.sunkcost.metadata.SunkProxyMetadatable
import org.bukkit.BlockChangeDelegate
import org.bukkit.Chunk
import org.bukkit.ChunkSnapshot
import org.bukkit.Difficulty
import org.bukkit.Effect
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.Particle
import org.bukkit.Sound
import org.bukkit.SoundCategory
import org.bukkit.TreeType
import org.bukkit.World
import org.bukkit.WorldBorder
import org.bukkit.WorldType
import org.bukkit.block.Biome
import org.bukkit.block.Block
import org.bukkit.entity.Arrow
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.FallingBlock
import org.bukkit.entity.Item
import org.bukkit.entity.LightningStrike
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player
import org.bukkit.generator.BlockPopulator
import org.bukkit.generator.ChunkGenerator
import org.bukkit.inventory.ItemStack
import org.bukkit.material.MaterialData
import org.bukkit.metadata.Metadatable
import org.bukkit.plugin.Plugin
import org.bukkit.util.Consumer
import org.bukkit.util.Vector
import org.jetbrains.annotations.Contract
import org.spongepowered.api.data.key.Keys
import org.spongepowered.api.entity.EntityTypes
import org.spongepowered.api.entity.weather.Lightning
import java.io.File
import java.util.UUID
import kotlin.math.abs
import org.spongepowered.api.entity.Item as SItem
import org.spongepowered.api.entity.living.player.Player as SPlayer
import org.spongepowered.api.world.Chunk as SChunk
import org.spongepowered.api.world.World as SWorld

class SunkWorld(val world: SWorld) : World, Metadatable by SunkProxyMetadatable(world) {

    override fun setWaterAnimalSpawnLimit(limit: Int) {} // not exposed

    override fun getPVP(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @Contract("null -> null; !null -> !null")
    override fun getGameRuleValue(rule: String?): String? {
        if (rule == null) {
            return null
        }
        return world.getGameRule(rule).unwrap()
    }

    override fun getAllowAnimals(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAnimalSpawnLimit(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getListeningPluginChannels(): MutableSet<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun spawnEntity(loc: Location, type: EntityType): Entity {
        val entity = world.createEntity(type.sEntityType(), loc.vector3d())
        if (!world.spawnEntity(entity)) {
            entity.remove()
            throw IllegalArgumentException("type")
        }
        return SunkEntity(entity)
    }

    override fun getFullTime(): Long = world.properties.worldTime

    override fun getThunderDuration(): Int = world.properties.thunderTime

    override fun dropItemNaturally(location: Location?, item: ItemStack?): Item {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setStorm(hasStorm: Boolean) {
        world.properties.isRaining = hasStorm
    }

    override fun getBiome(x: Int, z: Int): Biome {
        return world.getBiome(x, 0, z).biome()
    }

    override fun getNearbyEntities(location: Location, x: Double, y: Double, z: Double): Collection<Entity> {
        return world.entities.filter {
            abs(it.location.x - location.x) < x &&
                    abs(it.location.y - location.y) < y &&
                    abs(it.location.z - location.z) < z
        }.map { SunkEntity(it) }
    }

    override fun isChunkLoaded(chunk: Chunk): Boolean {
        return (chunk as SunkChunk).isLoaded
    }

    override fun isChunkLoaded(x: Int, z: Int): Boolean {
        return world.getChunkAtBlock(x, 0, z).unwrap()?.isLoaded ?: false
    }

    override fun spigot(): World.Spigot = Spigot(this)

    override fun getDifficulty(): Difficulty = world.difficulty.bDifficulty()

    override fun isChunkInUse(x: Int, z: Int): Boolean {
        val chunk = world.getChunkAtBlock(x, 0, z).unwrap() ?: return false
        return chunk.getEntities { it is SPlayer }.isNotEmpty()
    }

    override fun getTime(): Long = world.properties.worldTime % 24000

    override fun setTime(time: Long) {
        world.properties.worldTime = world.properties.worldTime % 24000 + time % 24000
    }

    override fun setThunderDuration(duration: Int) {
        world.properties.thunderTime = duration
    }

    override fun regenerateChunk(x: Int, z: Int): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setTicksPerAnimalSpawns(ticksPerAnimalSpawns: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getHighestBlockAt(x: Int, z: Int): Block {
        return world.getLocation(world.getHighestPositionAt(Vector3i(x, 0, z))).toBlock()
    }

    override fun getHighestBlockAt(location: Location): Block {
        return world.getLocation(world.getHighestPositionAt(location.vector3i())).toBlock()
    }

    override fun isAutoSave(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun playSound(location: Location?, sound: Sound?, volume: Float, pitch: Float) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun playSound(location: Location?, sound: String?, volume: Float, pitch: Float) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun playSound(location: Location?, sound: Sound?, category: SoundCategory?, volume: Float, pitch: Float) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun playSound(location: Location?, sound: String?, category: SoundCategory?, volume: Float, pitch: Float) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun sendPluginMessage(source: Plugin?, channel: String?, message: ByteArray?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setDifficulty(difficulty: Difficulty) {
        world.properties.difficulty = difficulty.sDifficulty()
    }

    override fun getTicksPerMonsterSpawns(): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getHighestBlockYAt(x: Int, z: Int): Int {
        return world.getHighestYAt(x, z)
    }

    override fun getHighestBlockYAt(location: Location): Int {
        return world.getHighestYAt(location.blockX, location.blockZ)
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : Entity> getEntitiesByClass(vararg classes: Class<T>): Collection<T> {
        return world.entities.map { SunkEntity(it) }.filter { e -> classes.any { it.isAssignableFrom(e::class.java) } } as List<T>
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : Entity> getEntitiesByClass(cls: Class<T>): Collection<T> {
        return world.entities.map { SunkEntity(it) }.filter { cls.isAssignableFrom(it::class.java) } as List<T>
    }

    override fun getWorldFolder(): File {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setGameRuleValue(rule: String?, value: String?): Boolean {
        if (rule == null) {
            return false
        }
        return if (value == null) {
            try {
                world.properties.removeGameRule(rule)
                true
            } catch (e: Exception) {
                false
            }
        } else {
            try {
                world.properties.setGameRule(rule, value)
                true
            } catch (e: Exception) {
                false
            }
        }
    }

    override fun setAutoSave(value: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setKeepSpawnInMemory(keepLoaded: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setFullTime(time: Long) {
        world.properties.worldTime = time
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : Entity> spawn(location: Location, clazz: Class<T>): T? {
        val type = clazz.entityType().sEntityType()
        val entity = world.createEntity(type, location.vector3d())
        if (!world.spawnEntity(entity)) {
            entity.remove()
            throw IllegalArgumentException("could not spawn")
        }
        return SunkEntity(entity) as T
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : Entity> spawn(location: Location, clazz: Class<T>, function: Consumer<T>): T {
        val type = clazz.entityType().sEntityType()
        val entity = world.createEntity(type, location.vector3d())
        val sunk = SunkEntity(entity) as T
        function.accept(sunk)
        if (!world.spawnEntity(entity)) {
            entity.remove()
            throw IllegalArgumentException("could not spawn")
        }
        return sunk
    }

    override fun getGameRules(): Array<String> {
        return world.gameRules.keys.toTypedArray()
    }

    override fun setAnimalSpawnLimit(limit: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setSpawnLocation(location: Location?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setSpawnLocation(x: Int, y: Int, z: Int): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getSpawnLocation(): Location {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getWorldType(): WorldType {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun spawnFallingBlock(location: Location, data: MaterialData): FallingBlock {
        val entity = world.createEntity(EntityTypes.FALLING_BLOCK, location.vector3d())
        val blockstate = data.toBlockState() ?: throw IllegalArgumentException("data")
        entity[Keys.REPRESENTED_BLOCK] = blockstate
        if (!world.spawnEntity(entity)) {
            entity.remove()
            throw IllegalArgumentException("could not spawn")
        }
        return SunkEntity(entity) as FallingBlock // autocast
    }

    override fun spawnFallingBlock(location: Location, material: Material, data: Byte): FallingBlock {
        val materialdata = material.getNewData(data) ?: throw IllegalArgumentException("blockData")
        if (!material.isBlock) {
            throw IllegalArgumentException("material")
        }
        return spawnFallingBlock(location, materialdata)
    }

    override fun spawnFallingBlock(location: Location, blockId: Int, blockData: Byte): FallingBlock {
        val material = Material.getMaterial(blockId) ?: throw IllegalArgumentException("blockId")
        if (!material.isBlock) {
            throw IllegalArgumentException("blockId")
        }
        val materialdata = material.getNewData(blockData) ?: throw IllegalArgumentException("blockData")
        return spawnFallingBlock(location, materialdata)
    }

    override fun isThundering(): Boolean = world.properties.isThundering

    override fun getTicksPerAnimalSpawns(): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadChunk(chunk: Chunk) {
        loadChunk(chunk.x, chunk.z)
    }

    override fun loadChunk(x: Int, z: Int) {
        loadChunk(x, z, false)
    }

    override fun loadChunk(x: Int, z: Int, generate: Boolean): Boolean {
        return world.loadChunk(x, 0, z, generate).isPresent
    }

    override fun setMonsterSpawnLimit(limit: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMonsterSpawnLimit(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isGameRule(rule: String): Boolean {
        return world.getGameRule(rule).isPresent
    }

    override fun setTicksPerMonsterSpawns(ticksPerMonsterSpawns: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun save() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getEmptyChunkSnapshot(
        x: Int,
        z: Int,
        includeBiome: Boolean,
        includeBiomeTempRain: Boolean
    ): ChunkSnapshot {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getUID(): UUID = world.uniqueId

    //todo check if you can get unloaded chunks in spigot

    override fun getChunkAt(x: Int, z: Int): Chunk? = world.getChunkAtBlock(x, 0, z).unwrap()?.let { SunkChunk(it) }

    override fun getChunkAt(location: Location): Chunk? = getChunkAt(location.blockX, location.blockZ)

    override fun getChunkAt(block: Block): Chunk? = getChunkAt(block.location)

    override fun getWorldBorder(): WorldBorder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAmbientSpawnLimit(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun dropItem(location: Location, item: ItemStack): Item? {
        val stack = SunkItemStack(item).stack
        val entity = world.createEntity(EntityTypes.ITEM, location.vector3d()) as SItem
        entity[Keys.REPRESENTED_ITEM] = stack.createSnapshot()
        if (!world.spawnEntity(entity)) {
            return null
        }
        return SunkEntity(entity) as Item // autocast
    }

    override fun unloadChunk(chunk: Chunk): Boolean = (chunk as SunkChunk).chunk.unloadChunk()

    override fun unloadChunk(x: Int, z: Int): Boolean = unloadChunk(x, z, true)

    override fun unloadChunk(x: Int, z: Int, save: Boolean): Boolean = unloadChunk(x, z, save, true)

    override fun unloadChunk(x: Int, z: Int, save: Boolean, safe: Boolean): Boolean {
        val chunk = world.getChunkAtBlock(x, 0, z).unwrap() ?: return false
        return chunk.unloadChunk()
    }

    override fun hasStorm(): Boolean = world.properties.isRaining

    override fun setWeatherDuration(duration: Int) {
        world.properties.rainTime = duration
    }

    override fun getMaxHeight(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getKeepSpawnInMemory(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun spawnParticle(particle: Particle?, location: Location?, count: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun spawnParticle(particle: Particle?, x: Double, y: Double, z: Double, count: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T : Any?> spawnParticle(particle: Particle?, location: Location?, count: Int, data: T) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T : Any?> spawnParticle(particle: Particle?, x: Double, y: Double, z: Double, count: Int, data: T) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun spawnParticle(
        particle: Particle?,
        location: Location?,
        count: Int,
        offsetX: Double,
        offsetY: Double,
        offsetZ: Double
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun spawnParticle(
        particle: Particle?,
        x: Double,
        y: Double,
        z: Double,
        count: Int,
        offsetX: Double,
        offsetY: Double,
        offsetZ: Double
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T : Any?> spawnParticle(
        particle: Particle?,
        location: Location?,
        count: Int,
        offsetX: Double,
        offsetY: Double,
        offsetZ: Double,
        data: T
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T : Any?> spawnParticle(
        particle: Particle?,
        x: Double,
        y: Double,
        z: Double,
        count: Int,
        offsetX: Double,
        offsetY: Double,
        offsetZ: Double,
        data: T
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun spawnParticle(
        particle: Particle?,
        location: Location?,
        count: Int,
        offsetX: Double,
        offsetY: Double,
        offsetZ: Double,
        extra: Double
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun spawnParticle(
        particle: Particle?,
        x: Double,
        y: Double,
        z: Double,
        count: Int,
        offsetX: Double,
        offsetY: Double,
        offsetZ: Double,
        extra: Double
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T : Any?> spawnParticle(
        particle: Particle?,
        location: Location?,
        count: Int,
        offsetX: Double,
        offsetY: Double,
        offsetZ: Double,
        extra: Double,
        data: T
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T : Any?> spawnParticle(
        particle: Particle?,
        x: Double,
        y: Double,
        z: Double,
        count: Int,
        offsetX: Double,
        offsetY: Double,
        offsetZ: Double,
        extra: Double,
        data: T
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getWaterAnimalSpawnLimit(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun spawnArrow(location: Location?, direction: Vector?, speed: Float, spread: Float): Arrow {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T : Arrow?> spawnArrow(
        location: Location?,
        direction: Vector?,
        speed: Float,
        spread: Float,
        clazz: Class<T>?
    ): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getWeatherDuration(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getSeaLevel(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setSpawnFlags(allowMonsters: Boolean, allowAnimals: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLivingEntities(): MutableList<LivingEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getName(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLoadedChunks(): Array<Chunk> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun canGenerateStructures(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unloadChunkRequest(x: Int, z: Int): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unloadChunkRequest(x: Int, z: Int, safe: Boolean): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun strikeLightningEffect(loc: Location): LightningStrike? {
        val lightning = world.createEntity(EntityTypes.LIGHTNING, loc.vector3d()) as Lightning
        WorldListener.addLightningEffect(lightning.uniqueId)
        if (!world.spawnEntity(lightning)) {
            lightning.remove()
            return null
        }
        return SunkEntity(lightning) as LightningStrike // autocast
    }

    override fun createExplosion(x: Double, y: Double, z: Double, power: Float): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createExplosion(x: Double, y: Double, z: Double, power: Float, setFire: Boolean): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createExplosion(
        x: Double,
        y: Double,
        z: Double,
        power: Float,
        setFire: Boolean,
        breakBlocks: Boolean
    ): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createExplosion(loc: Location?, power: Float): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createExplosion(loc: Location?, power: Float, setFire: Boolean): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setPVP(pvp: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun refreshChunk(x: Int, z: Int): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getSeed(): Long = world.properties.seed

    override fun getPlayers(): List<Player> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getTemperature(x: Int, z: Int): Double = world.getBiome(x, 0, z).temperature

    override fun getEntitiesByClasses(vararg classes: Class<*>): Collection<Entity> =
        world.entities.map { SunkEntity(it) }.filter { e -> classes.any { it.isAssignableFrom(e::class.java) } }

    override fun getPopulators(): MutableList<BlockPopulator> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setBiome(x: Int, z: Int, bio: Biome) {
        world.setBiome(x, 0, z, bio.biomeType())
    }

    override fun strikeLightning(loc: Location): LightningStrike? {
        val lightning = world.createEntity(EntityTypes.LIGHTNING, loc.vector3d()) as Lightning
        if (!world.spawnEntity(lightning)) {
            lightning.remove()
            return null
        }
        return SunkEntity(lightning) as LightningStrike // autocast
    }

    override fun getBlockAt(x: Int, y: Int, z: Int): Block = world.getLocation(x, y, z).toBlock()

    override fun getBlockAt(location: Location): Block = world.getLocation(location.vector3i()).toBlock()

    override fun getEntities(): List<Entity> = world.entities.map { SunkEntity(it) }

    override fun getAllowMonsters(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun generateTree(location: Location?, type: TreeType?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun generateTree(loc: Location?, type: TreeType?, delegate: BlockChangeDelegate?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getEnvironment(): World.Environment {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun playEffect(location: Location?, effect: Effect?, data: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun playEffect(location: Location?, effect: Effect?, data: Int, radius: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T : Any?> playEffect(location: Location?, effect: Effect?, data: T) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T : Any?> playEffect(location: Location?, effect: Effect?, data: T, radius: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setAmbientSpawnLimit(limit: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getBlockTypeIdAt(x: Int, y: Int, z: Int): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getBlockTypeIdAt(location: Location?): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getGenerator(): ChunkGenerator {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setThundering(thundering: Boolean) {
        world.properties.isThundering = thundering
    }

    override fun getHumidity(x: Int, z: Int): Double {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun equals(other: Any?): Boolean = other is SunkWorld && other.world == world

    override fun hashCode(): Int = world.hashCode()

    class Spigot(val world: SunkWorld) : World.Spigot() {

        override fun playEffect(location: Location?, effect: Effect?) {
            super.playEffect(location, effect)
        }

        override fun playEffect(
            location: Location?,
            effect: Effect?,
            id: Int,
            data: Int,
            offsetX: Float,
            offsetY: Float,
            offsetZ: Float,
            speed: Float,
            particleCount: Int,
            radius: Int
        ) {
            super.playEffect(location, effect, id, data, offsetX, offsetY, offsetZ, speed, particleCount, radius)
        }

        override fun strikeLightningEffect(loc: Location?, isSilent: Boolean): LightningStrike {
            return super.strikeLightningEffect(loc, isSilent)
        }

        override fun strikeLightning(loc: Location?, isSilent: Boolean): LightningStrike {
            return super.strikeLightning(loc, isSilent)
        }
    }

}
