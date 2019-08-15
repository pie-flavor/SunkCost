package flavor.pie.sunkcost

import flavor.pie.kludge.*
import flavor.pie.sunkcost.command.SunkConsoleCommandSender
import flavor.pie.sunkcost.inventory.CustomHolderProperty
import flavor.pie.sunkcost.inventory.SunkInventory
import flavor.pie.sunkcost.inventory.SunkInventoryHolder
import flavor.pie.sunkcost.inventory.toArchetype
import flavor.pie.sunkcost.inventory.toGuiId
import flavor.pie.sunkcost.plugin.SunkPluginManager
import flavor.pie.sunkcost.scoreboards.SunkScoreboardManager
import net.md_5.bungee.api.chat.BaseComponent
import org.bukkit.BanList
import org.bukkit.GameMode
import org.bukkit.NamespacedKey
import org.bukkit.OfflinePlayer
import org.bukkit.Server
import org.bukkit.UnsafeValues
import org.bukkit.Warning
import org.bukkit.World
import org.bukkit.WorldCreator
import org.bukkit.advancement.Advancement
import org.bukkit.boss.BarColor
import org.bukkit.boss.BarFlag
import org.bukkit.boss.BarStyle
import org.bukkit.boss.BossBar
import org.bukkit.command.CommandSender
import org.bukkit.command.ConsoleCommandSender
import org.bukkit.command.PluginCommand
import org.bukkit.entity.Entity
import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryType
import org.bukkit.generator.ChunkGenerator
import org.bukkit.help.HelpMap
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.InventoryHolder
import org.bukkit.inventory.ItemFactory
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.Merchant
import org.bukkit.inventory.Recipe
import org.bukkit.map.MapView
import org.bukkit.plugin.Plugin
import org.bukkit.plugin.PluginManager
import org.bukkit.plugin.ServicesManager
import org.bukkit.plugin.messaging.Messenger
import org.bukkit.scheduler.BukkitScheduler
import org.bukkit.scoreboard.ScoreboardManager
import org.bukkit.util.CachedServerIcon
import org.spongepowered.api.item.inventory.InventoryArchetypes
import org.spongepowered.api.item.inventory.property.GuiIdProperty
import org.spongepowered.api.item.inventory.property.InventoryDimension
import org.spongepowered.api.item.inventory.property.InventoryTitle
import org.spongepowered.api.service.whitelist.WhitelistService
import org.spongepowered.api.text.channel.MessageChannel
import java.awt.image.BufferedImage
import java.io.File
import java.util.UUID
import java.util.logging.Logger
import org.spongepowered.api.item.inventory.Inventory as SInventory

object SunkServer : Server {
    override fun isHardcore(): Boolean = false // not exposed

    override fun createInventory(owner: InventoryHolder?, type: InventoryType): Inventory {
        val inventory = SInventory.builder()
            .of(type.toArchetype())
        type.toGuiId()?.let { inventory.property(GuiIdProperty(it)) }
        if (owner != null) {
            if (owner is SunkInventoryHolder) {
                inventory.forCarrier(owner.carrier)
            } else {
                inventory.property(CustomHolderProperty(owner))
            }
        }
        return SunkInventory(inventory.build(plugin))
    }

    override fun createInventory(owner: InventoryHolder?, type: InventoryType, title: String): Inventory {
        val inventory = SInventory.builder()
            .of(type.toArchetype())
            .property(InventoryTitle.of(title.textByCode()))
        type.toGuiId()?.let { inventory.property(GuiIdProperty(it)) }
        if (owner != null) {
            if (owner is SunkInventoryHolder) {
                inventory.forCarrier(owner.carrier)
            } else {
                inventory.property(CustomHolderProperty(owner))
            }
        }
        return SunkInventory(inventory.build(plugin))
    }

    override fun createInventory(owner: InventoryHolder?, size: Int): Inventory {
        if (size % 9 != 0 || size == 0) {
            throw IllegalArgumentException("size")
        }
        val inventory = SInventory.builder()
            .of(InventoryArchetypes.CHEST)
            .property(InventoryDimension.of(9, size / 9))
        if (owner != null) {
            if (owner is SunkInventoryHolder) {
                inventory.forCarrier(owner.carrier)
            } else {
                inventory.property(CustomHolderProperty(owner))
            }
        }
        return SunkInventory(inventory.build(plugin))
    }

    override fun createInventory(owner: InventoryHolder?, size: Int, title: String): Inventory {
        if (size % 9 == 0 || size == 0) {
            throw IllegalArgumentException("size")
        }
        val inventory = SInventory.builder()
            .of(InventoryArchetypes.CHEST)
            .property(InventoryDimension.of(9, size / 9))
        if (owner != null) {
            if (owner is SunkInventoryHolder) {
                inventory.forCarrier(owner.carrier)
            } else {
                inventory.property(CustomHolderProperty(owner))
            }
        }
        return SunkInventory(inventory.build(plugin))
    }

    override fun getSpawnRadius(): Int = 16 // not exposed

    override fun getOperators(): MutableSet<OfflinePlayer> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun savePlayers() {} // not exposed

    override fun getLogger(): Logger {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getIp(): String = Server.boundAddress.map { it.hostString }.orElse("")

    override fun getConsoleSender(): ConsoleCommandSender = SunkConsoleCommandSender(Server.console)

    override fun addRecipe(recipe: Recipe?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAnimalSpawnLimit(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getListeningPluginChannels(): MutableSet<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getPort(): Int = Server.boundAddress.map { it.port }.unwrap() ?: 25565

    override fun getVersion(): String = SunkCost.VERSION

    override fun getMap(id: Short): MapView {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getOfflinePlayers(): Array<OfflinePlayer> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getScoreboardManager(): ScoreboardManager = SunkScoreboardManager

    override fun createChunkData(world: World?): ChunkGenerator.ChunkData {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setWhitelist(value: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getIdleTimeout(): Int = Server.playerIdleTimeout

    override fun getMaxPlayers(): Int = Server.maxPlayers

    override fun spigot(): Server.Spigot = Spigot

    override fun getAdvancement(key: NamespacedKey?): Advancement {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMotd(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAllowEnd(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getWarningState(): Warning.WarningState {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun advancementIterator(): MutableIterator<Advancement> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAllowFlight(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCommandAliases(): MutableMap<String, Array<String>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemFactory(): ItemFactory {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getWorldContainer(): File {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun sendPluginMessage(source: Plugin?, channel: String?, message: ByteArray?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setSpawnRadius(value: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setIdleTimeout(threshold: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getTicksPerMonsterSpawns(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun recipeIterator(): MutableIterator<Recipe> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getDefaultGameMode(): GameMode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setDefaultGameMode(mode: GameMode?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun reloadData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun resetRecipes() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getShutdownMessage(): String = "Server shutting down"

    override fun getConnectionThrottle(): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getRecipesFor(result: ItemStack?): MutableList<Recipe> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getPlayer(name: String?): Player {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getPlayer(id: UUID?): Player {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun reloadWhitelist() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun clearRecipes() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun shutdown() {
        Server.shutdown()
    }

    override fun getOnlineMode(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getWorlds(): MutableList<World> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getBukkitVersion(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getWorldType(): String = Server.defaultWorld.unwrap()?.generatorType?.name?.toUpperCase() ?: "DEFAULT"

    override fun reload() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getUpdateFolderFile(): File {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun banIP(address: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getServerIcon(): CachedServerIcon {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getTicksPerAnimalSpawns(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getBannedPlayers(): MutableSet<OfflinePlayer> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getBanList(type: BanList.Type?): BanList {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMonsterSpawnLimit(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createMerchant(title: String?): Merchant {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getViewDistance(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unloadWorld(name: String?, save: Boolean): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unloadWorld(world: World?, save: Boolean): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAmbientSpawnLimit(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getEntity(uuid: UUID?): Entity {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun dispatchCommand(sender: CommandSender?, commandLine: String?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getPlayerExact(name: String?): Player {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getIPBans(): MutableSet<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAllowNether(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getServicesManager(): ServicesManager {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getOfflinePlayer(name: String?): OfflinePlayer {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getOfflinePlayer(id: UUID?): OfflinePlayer {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unbanIP(address: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getHelpMap(): HelpMap {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun broadcastMessage(message: String?): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getServerName(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getWaterAnimalSpawnLimit(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createBossBar(title: String?, color: BarColor?, style: BarStyle?, vararg flags: BarFlag?): BossBar {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getName(): String = SunkCost.NAME

    override fun getPluginCommand(name: String?): PluginCommand {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getOnlinePlayers(): MutableCollection<out Player> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getGenerateStructures(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getWhitelistedPlayers(): MutableSet<OfflinePlayer> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getScheduler(): BukkitScheduler {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createMap(world: World?): MapView {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getUnsafe(): UnsafeValues {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createWorld(creator: WorldCreator?): World {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getWorld(name: String?): World {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getWorld(uid: UUID?): World {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isPrimaryThread(): Boolean = Server.isMainThread

    override fun getServerId(): String = id

    private var id = ""

    internal fun setServerId(id: String) {
        this.id = id
    }

    override fun broadcast(message: String, permission: String): Int {
        val chan = MessageChannel.permission(permission)
        chan.send(message.textByCode())
        return chan.members.size
    }

    override fun loadServerIcon(file: File?): CachedServerIcon {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadServerIcon(image: BufferedImage?): CachedServerIcon {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hasWhitelist(): Boolean {
        val svc: WhitelistService? by Service
        return svc?.whitelistedProfiles?.isNotEmpty() ?: false
    }

    override fun getUpdateFolder(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getPluginManager(): PluginManager = SunkPluginManager

    override fun matchPlayer(name: String?): MutableList<Player> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMessenger(): Messenger {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    object Spigot : Server.Spigot() {

        override fun broadcast(component: BaseComponent) {
            Server.broadcastChannel.send(component.toText())
        }

        override fun broadcast(vararg components: BaseComponent) {
            for (component in components) {
                Server.broadcastChannel.send(component.toText())
            }
        }
    }
}
