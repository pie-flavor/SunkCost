package flavor.pie.sunkcost

import flavor.pie.kludge.*
import flavor.pie.sunkcost.entity.SunkEntity
import flavor.pie.sunkcost.entity.SunkLivingEntity
import flavor.pie.sunkcost.inventory.SunkItemStack
import flavor.pie.sunkcost.inventory.mainHand
import flavor.pie.sunkcost.material.toBlockState
import org.bukkit.Achievement
import org.bukkit.Effect
import org.bukkit.GameMode
import org.bukkit.Instrument
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.Note
import org.bukkit.OfflinePlayer
import org.bukkit.Particle
import org.bukkit.Sound
import org.bukkit.SoundCategory
import org.bukkit.Statistic
import org.bukkit.WeatherType
import org.bukkit.advancement.Advancement
import org.bukkit.advancement.AdvancementProgress
import org.bukkit.conversations.Conversation
import org.bukkit.conversations.ConversationAbandonedEvent
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.Player
import org.bukkit.entity.Villager
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.InventoryView
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.MainHand
import org.bukkit.inventory.Merchant
import org.bukkit.inventory.PlayerInventory
import org.bukkit.map.MapView
import org.bukkit.plugin.Plugin
import org.bukkit.scoreboard.Scoreboard
import org.spongepowered.api.data.key.Keys
import org.spongepowered.api.data.type.HandPreferences
import org.spongepowered.api.data.type.HandTypes
import org.spongepowered.api.entity.living.player.gamemode.GameModes
import org.spongepowered.api.resourcepack.ResourcePacks
import org.spongepowered.api.text.title.Title
import org.spongepowered.api.util.RespawnLocation
import java.net.InetSocketAddress
import java.net.URI
import org.spongepowered.api.entity.living.player.Player as SPlayer


class SunkPlayer(val sPlayer: SPlayer): SunkLivingEntity(sPlayer), OfflinePlayer by SunkOfflinePlayer(sPlayer), Player {
    override fun spigot(): Player.Spigot {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun playEffect(loc: Location?, effect: Effect?, data: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T : Any?> playEffect(loc: Location?, effect: Effect?, data: T) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setTotalExperience(exp: Int) {
        sPlayer[Keys.TOTAL_EXPERIENCE] = exp
    }

    override fun performCommand(command: String): Boolean = CommandManager.process(sPlayer, command).successCount.orElse(0) > 0

    override fun chat(msg: String) {
        if (msg.startsWith("/")) {
            performCommand(msg.substring(1))
        } else {
            sPlayer.simulateChat(msg.textByCode(), CauseStackManager.currentCause)
        }
    }

    override fun openMerchant(trader: Villager?, force: Boolean): InventoryView {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun openMerchant(merchant: Merchant?, force: Boolean): InventoryView {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getListeningPluginChannels(): Set<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setAllowFlight(flight: Boolean) {
        sPlayer[Keys.CAN_FLY] = flight
    }

    override fun abandonConversation(conversation: Conversation?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun abandonConversation(conversation: Conversation?, details: ConversationAbandonedEvent?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun stopSound(sound: Sound) {
        sPlayer.stopSounds(sound.soundType())
    }

    override fun stopSound(sound: String) {
        stopSound(Sound.valueOf(sound))
    }

    override fun stopSound(sound: Sound, category: SoundCategory?) {
        if (category == null) {
            stopSound(sound)
        } else {
            sPlayer.stopSounds(sound.soundType(), category.sCategory())
        }
    }

    override fun stopSound(sound: String, category: SoundCategory?) {
        if (category == null) {
            stopSound(sound)
        } else {
            stopSound(Sound.valueOf(sound), category)
        }
    }

    override fun updateInventory() {} // lol

    override fun getEnderChest(): Inventory {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isBlocking(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isSleepingIgnored(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isSleeping(): Boolean = sPlayer[Keys.IS_SLEEPING].unwrap() ?: false

    override fun getWalkSpeed(): Float = sPlayer[Keys.WALKING_SPEED].unwrap()?.toFloat() ?: 0.1f

    override fun showPlayer(player: Player?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showPlayer(plugin: Plugin?, player: Player?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getStatistic(statistic: Statistic): Int = sPlayer[Keys.STATISTICS].unwrap()?.get(statistic.sStatistic())?.toInt() ?: -1

    override fun getStatistic(statistic: Statistic?, material: Material?): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getStatistic(statistic: Statistic?, entityType: EntityType?): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setDisplayName(name: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setItemInHand(item: ItemStack) {
        sPlayer.setItemInHand(HandTypes.MAIN_HAND, SunkItemStack(item).stack)
    }

    override fun getFlySpeed(): Float = sPlayer[Keys.FLYING_SPEED].unwrap()?.toFloat() ?: 0.1f

    override fun hasCooldown(material: Material): Boolean {
        return sPlayer.cooldownTracker.hasCooldown(material.toItemType() ?: return false)
    }

    override fun setSpectatorTarget(entity: Entity?) {
        sPlayer.setSpectatorTarget((entity as SunkEntity?)?.entity)
    }

    override fun sendTitle(title: String?, subtitle: String?) {
        sendTitle(title, subtitle, -1, -1, -1)
    }

    override fun sendTitle(title: String?, subtitle: String?, fadeIn: Int, stay: Int, fadeOut: Int) {
        if (title == null || subtitle == null) {
            return
        }
        sPlayer.sendTitle(Title.builder().apply {
            if (title.isNotEmpty()) {
                title(title.textByCode())
            }
            if (subtitle.isNotEmpty()) {
                subtitle(subtitle.textByCode())
            }
            if (fadeIn != -1) {
                fadeIn(fadeIn)
            }
            if (fadeOut != -1) {
                fadeOut(fadeOut)
            }
            if (stay != -1) {
                stay(stay)
            }
        }.build())
    }

    override fun openEnchanting(location: Location?, force: Boolean): InventoryView {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun giveExpLevels(amount: Int) {
        sPlayer[Keys.EXPERIENCE_LEVEL] = sPlayer[Keys.EXPERIENCE_LEVEL].orElse(0) + amount
    }

    override fun playNote(loc: Location?, instrument: Byte, note: Byte) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun playNote(loc: Location?, instrument: Instrument?, note: Note?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setPlayerTime(time: Long, relative: Boolean) {
        TODO("not implemented")
    }

    override fun getItemOnCursor(): ItemStack {
        TODO("not implemented")
    }

    override fun setShoulderEntityLeft(entity: Entity?) {
        TODO("not implemented")
    }

    override fun setWalkSpeed(value: Float) {
        sPlayer[Keys.WALKING_SPEED] = value.toDouble()
    }

    override fun setExhaustion(value: Float) {
        sPlayer[Keys.EXHAUSTION] = value.toDouble()
    }

    override fun setHealthScaled(scale: Boolean) {
        TODO("not implemented")
    }

    override fun setStatistic(statistic: Statistic?, newValue: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setStatistic(statistic: Statistic?, material: Material?, newValue: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setStatistic(statistic: Statistic?, entityType: EntityType?, newValue: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setWindowProperty(prop: InventoryView.Property?, value: Int): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setFlySpeed(value: Float) {
        sPlayer[Keys.FLYING_SPEED] = value.toDouble()
    }

    override fun setSneaking(sneak: Boolean) {
        sPlayer[Keys.IS_SNEAKING] = sneak
    }

    override fun setScoreboard(scoreboard: Scoreboard?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getExp(): Float {
        return sPlayer[Keys.EXPERIENCE_FROM_START_OF_LEVEL].orElse(1).toFloat() /
                sPlayer[Keys.EXPERIENCE_SINCE_LEVEL].orElse(0).toFloat()
    }

    override fun acceptConversationInput(input: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun sendRawMessage(message: String) {
        sPlayer.sendMessage(message.textByJson())
    }

    override fun isFlying(): Boolean = sPlayer[Keys.IS_FLYING].orElse(false)

    override fun sendChunkChange(loc: Location?, sx: Int, sy: Int, sz: Int, data: ByteArray?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setPlayerWeather(type: WeatherType?) {
        TODO("not implemented")
    }

    override fun getSleepTicks(): Int {
        TODO("not implemented")
    }

    override fun getInventory(): PlayerInventory {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setFlying(value: Boolean) {
        sPlayer[Keys.IS_FLYING] = value
    }

    override fun getOpenInventory(): InventoryView {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getPlayerWeather(): WeatherType {
        TODO("not implemented")
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

    override fun closeInventory() {
        sPlayer.closeInventory()
    }

    override fun sendSignChange(loc: Location?, lines: Array<out String>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getExpToLevel(): Int = sPlayer[Keys.EXPERIENCE_FROM_START_OF_LEVEL].orElse(1)

    override fun getSaturation(): Float = sPlayer[Keys.SATURATION].orElse(0.0).toFloat()

    override fun getShoulderEntityLeft(): Entity {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isConversing(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLevel(): Int = sPlayer[Keys.EXPERIENCE_LEVEL].orElse(0)

    override fun setBedSpawnLocation(location: Location) = setBedSpawnLocation(location, false)

    override fun setBedSpawnLocation(location: Location, force: Boolean) {
        val respawn = RespawnLocation.builder().location(location.sLocation()).forceSpawn(force).build()
        val locs = sPlayer[Keys.RESPAWN_LOCATIONS].orElseGet(::mutableMapOf)
        locs[location.world.uid] = respawn
        sPlayer[Keys.RESPAWN_LOCATIONS] = locs
    }

    override fun setTexturePack(url: String) {
        setResourcePack(url)
    }

    override fun getScoreboard(): Scoreboard {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setSaturation(value: Float) {
        sPlayer[Keys.SATURATION] = value.toDouble()
    }

    override fun resetPlayerTime() {
        TODO("not implemented")
    }

    override fun hidePlayer(player: Player?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hidePlayer(plugin: Plugin?, player: Player?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun kickPlayer(message: String?) {
        if (message == null) {
            sPlayer.kick()
        } else {
            sPlayer.kick(message.textByCode())
        }
    }

    override fun setCompassTarget(loc: Location) {
        sPlayer[Keys.TARGETED_LOCATION] = loc.vector3d()
    }

    override fun getCompassTarget(): Location =
        (sPlayer[Keys.TARGETED_LOCATION].unwrap()?.let { sPlayer.world.getLocation(it) } ?: sPlayer.world.spawnLocation).bLocation()

    override fun getPlayerTimeOffset(): Long {
        TODO("not implemented")
    }

    override fun getTotalExperience(): Int = sPlayer[Keys.TOTAL_EXPERIENCE].orElse(0)

    override fun openInventory(inventory: Inventory?): InventoryView {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun openInventory(inventory: InventoryView?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isSprinting(): Boolean = sPlayer[Keys.IS_SPRINTING].orElse(false)

    override fun setCooldown(material: Material, ticks: Int) {
        sPlayer.cooldownTracker.setCooldown(material.toItemType() ?: return, ticks)
    }

    override fun loadData() {
        TODO("not implemented")
    }

    override fun sendBlockChange(loc: Location, material: Material, data: Byte) {
        sPlayer.sendBlockChange(loc.vector3i(), material.getNewData(data).toBlockState() ?: return)
    }

    override fun sendBlockChange(loc: Location, material: Int, data: Byte) {
        sendBlockChange(loc, Material.getMaterial(material), data)
    }

    override fun setSleepingIgnored(isSleeping: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun resetPlayerWeather() {
        TODO("not implemented")
    }

    override fun giveExp(amount: Int) {
        sPlayer[Keys.TOTAL_EXPERIENCE] = sPlayer[Keys.TOTAL_EXPERIENCE].orElse(0) + amount
    }

    override fun setSprinting(sprinting: Boolean) {
        sPlayer[Keys.IS_SPRINTING] = sprinting
    }

    override fun getGameMode(): GameMode = sPlayer[Keys.GAME_MODE].orElse(GameModes.SURVIVAL).bGameMode()

    override fun setShoulderEntityRight(entity: Entity?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isHealthScaled(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAddress(): InetSocketAddress = sPlayer.connection.address

    override fun decrementStatistic(statistic: Statistic?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun decrementStatistic(statistic: Statistic?, amount: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun decrementStatistic(statistic: Statistic?, material: Material?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun decrementStatistic(statistic: Statistic?, material: Material?, amount: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun decrementStatistic(statistic: Statistic?, entityType: EntityType?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun decrementStatistic(statistic: Statistic?, entityType: EntityType?, amount: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAllowFlight(): Boolean = sPlayer[Keys.CAN_FLY].orElse(false)

    override fun getHealthScale(): Double = sPlayer[Keys.HEALTH_SCALE].orElse(1.0)

    override fun canSee(player: Player?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun playSound(location: Location, sound: Sound, volume: Float, pitch: Float) {
        sPlayer.playSound(sound.soundType(), location.vector3d(), volume.toDouble(), pitch.toDouble())
    }

    override fun playSound(location: Location, sound: String, volume: Float, pitch: Float) {
        playSound(location, Sound.valueOf(sound), volume, pitch)
    }

    override fun playSound(location: Location, sound: Sound, category: SoundCategory, volume: Float, pitch: Float) {
        sPlayer.playSound(sound.soundType(), category.sCategory(), location.vector3d(), volume.toDouble(), pitch.toDouble())
    }

    override fun playSound(location: Location, sound: String, category: SoundCategory, volume: Float, pitch: Float) {
        playSound(location, Sound.valueOf(sound), category, volume, pitch)
    }

    override fun setItemOnCursor(item: ItemStack?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun sendPluginMessage(source: Plugin?, channel: String?, message: ByteArray?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isSneaking(): Boolean = sPlayer[Keys.IS_SNEAKING].orElse(false)

    override fun getLocale(): String = sPlayer.locale.toString()

    override fun getExhaustion(): Float = sPlayer[Keys.EXHAUSTION].orElse(0.0).toFloat()

    override fun setExp(exp: Float) {
        val target = sPlayer[Keys.EXPERIENCE_FROM_START_OF_LEVEL].orElse(1)
        sPlayer[Keys.EXPERIENCE_SINCE_LEVEL] = (exp * target).toInt()
    }

    override fun removeAchievement(achievement: Achievement?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getPlayerTime(): Long {
        TODO("not implemented")
    }

    override fun isHandRaised(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCooldown(material: Material): Int {
        return sPlayer.cooldownTracker.getCooldown(material.toItemType() ?: return -1).orElse(-1)
    }

    override fun getSpectatorTarget(): Entity? {
        return sPlayer.spectatorTarget.unwrap()?.let { SunkEntity(it) }
    }

    override fun saveData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun incrementStatistic(statistic: Statistic?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun incrementStatistic(statistic: Statistic?, amount: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun incrementStatistic(statistic: Statistic?, material: Material?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun incrementStatistic(statistic: Statistic?, material: Material?, amount: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun incrementStatistic(statistic: Statistic?, entityType: EntityType?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun incrementStatistic(statistic: Statistic?, entityType: EntityType?, amount: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isPlayerTimeRelative(): Boolean {
        TODO("not implemented")
    }

    override fun hasAchievement(achievement: Achievement?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAdvancementProgress(advancement: Advancement?): AdvancementProgress {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun sendMap(map: MapView?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun awardAchievement(achievement: Achievement?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setLevel(level: Int) {
        sPlayer[Keys.EXPERIENCE_LEVEL] = level
    }

    override fun setFoodLevel(value: Int) {
        sPlayer[Keys.FOOD_LEVEL] = value
    }

    override fun beginConversation(conversation: Conversation?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMainHand(): MainHand = sPlayer[Keys.DOMINANT_HAND].orElse(HandPreferences.RIGHT).mainHand()

    override fun getShoulderEntityRight(): Entity {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getPlayerListName(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setGameMode(mode: GameMode) {
        sPlayer[Keys.GAME_MODE] = mode.sGameMode()
    }

    override fun getItemInHand(): ItemStack = sPlayer.getItemInHand(HandTypes.MAIN_HAND).unwrap()?.let(::SunkItemStack) ?: SunkItemStack.empty()

    override fun getFoodLevel(): Int = sPlayer[Keys.FOOD_LEVEL].orElse(0)

    override fun setHealthScale(scale: Double) {
        sPlayer[Keys.HEALTH_SCALE] = scale
    }

    override fun resetTitle() {
        sPlayer.resetTitle()
    }

    override fun setPlayerListName(name: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getDisplayName(): String {
        TODO("not implemented")
    }

    override fun setResourcePack(url: String) {
        sPlayer.sendResourcePack(ResourcePacks.fromUri(URI(url)))
    }

    override fun setResourcePack(url: String, hash: ByteArray?) {
        setResourcePack(url) // automatic
    }

    override fun openWorkbench(location: Location?, force: Boolean): InventoryView {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
