package flavor.pie.sunkcost.metadata

import com.google.common.collect.HashMultimap
import com.google.common.collect.SetMultimap
import org.bukkit.metadata.MetadataValue
import org.bukkit.metadata.Metadatable
import org.bukkit.plugin.Plugin
import java.util.WeakHashMap

class SunkProxyMetadatable(private val holder: Any) : Metadatable {

    init {
        map.putIfAbsent(holder, HashMultimap.create())
    }

    companion object {
        val map: WeakHashMap<Any, SetMultimap<String, MetadataValue>> = WeakHashMap()
    }

    override fun hasMetadata(metadataKey: String): Boolean = map[holder]!![metadataKey].isNotEmpty()

    override fun removeMetadata(metadataKey: String, owningPlugin: Plugin) {
        map[holder]!![metadataKey].removeIf { it.owningPlugin === owningPlugin }
    }

    override fun getMetadata(metadataKey: String): List<MetadataValue> {
        return map[holder]!![metadataKey].toList()
    }

    override fun setMetadata(metadataKey: String, newMetadataValue: MetadataValue) {
        map[holder]!![metadataKey] += newMetadataValue
    }
}
