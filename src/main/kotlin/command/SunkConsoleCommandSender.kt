package flavor.pie.sunkcost.command

import org.bukkit.command.ConsoleCommandSender
import org.bukkit.conversations.Conversation
import org.bukkit.conversations.ConversationAbandonedEvent
import org.spongepowered.api.command.source.ConsoleSource
import org.spongepowered.api.text.serializer.TextSerializers

class SunkConsoleCommandSender(source: ConsoleSource) : ConsoleCommandSender, SunkCommandSender(source) {

    override fun beginConversation(conversation: Conversation?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun acceptConversationInput(input: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun sendRawMessage(message: String) {
        source.sendMessage(TextSerializers.JSON.deserialize(message))
    }

    override fun isConversing(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun abandonConversation(conversation: Conversation?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun abandonConversation(conversation: Conversation?, details: ConversationAbandonedEvent?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
