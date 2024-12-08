package cs112.ud3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reminder extends ListItem {
    private String description;

    public Reminder(String name, LocalDate date, String description) {
        super(name, date);
        this.description = description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    @Override
    public void display() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String dateFmt = this.date.format(fmt);

        System.out.println("Title: " + this.title);
        System.out.println("Date: " + dateFmt);
        System.out.println("Description: " + this.description);
    }

    @Override
    public String prettyPrint() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String dateFmt = this.date.format(fmt);

        return String.format("Reminder: %s on %s: %s%n", this.title, dateFmt, this.description);
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String dateFmt = this.date.format(fmt);

        return String.format("Reminder{title: \"%s\", date: %s, description: \"%s\"}", this.title, dateFmt, this.description);
    }
}
