package oakbot.command;

import oakbot.bot.BotContext;
import oakbot.bot.ChatCommand;
import oakbot.bot.ChatResponse;
import oakbot.filter.GrootFilter;

/**
 * Makes the bot talk in Groot.
 * @author Michael Angstadt
 */
public class GrootCommand implements Command {
	private final GrootFilter filter;

	public GrootCommand(GrootFilter filter) {
		this.filter = filter;
	}

	@Override
	public String name() {
		return "groot";
	}

	@Override
	public HelpDoc help() {
		//@formatter:off
		return new HelpDoc.Builder(this)
			.summary("I am Groot.")
			.detail("Toggles a filter that makes Oak speak in Groot.")
			.includeSummaryWithDetail(false)
		.build();
		//@formatter:on
	}

	@Override
	public ChatResponse onMessage(ChatCommand chatCommand, BotContext context) {
		int roomId = chatCommand.getMessage().getRoomId();
		filter.toggle(roomId);
		return null;
	}
}
