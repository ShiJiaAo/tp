package seedu.address.logic.commands;

import seedu.address.model.Model;

public class HelpConsultationCommand extends HelpCommand{

    public static final String COMMAND_WORD = "help consultation";

    public static final String CONSULTATION_SYNTAX = "Consultation Input Format:\n"
            + "touch recur [name] Consultations [day] [time] [duration] [period]";

    @Override
    public CommandResult execute(Model model) {
        return new CommandResult(CONSULTATION_SYNTAX);
    }
}
