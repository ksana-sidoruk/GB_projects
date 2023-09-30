import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Trailrunnable[] participants = {
                new Human("Василий"),
                new Cat("Барсик"),
                new Android("R2D2")
        };

        Obstacle[] obstacles = {
                new Trail(),
                new Trunk(),
                new Trail(),
                new Trail()
        };

        ArrayList<Trailrunnable> winners = new ArrayList<>();
        ArrayList<Trailrunnable> losers = new ArrayList<>();

        for (int i = 0; i < participants.length; i++) {
            boolean hasFailure = false;
            for (int j = 0; j < obstacles.length; j++) {
                if (obstacles[j] instanceof Trail) {
                    if (participants[i].run((Trail) obstacles[j]) == false) {
                        losers.add(participants[i]);
                        hasFailure = true;
                        break;
                    }
                } else {
                    if (participants[i].jump((Trunk) obstacles[j]) == false) {
                        losers.add(participants[i]);
                        hasFailure = true;
                        break;
                    }
                }
            }
            if (hasFailure == false) {
                winners.add(participants[i]);
            }
        }
        if (!winners.isEmpty()) {
            System.out.println("\n=============================\nПолосу препятствий пробежали: ");
            for (Trailrunnable participant : winners) {
                System.out.println(participant);
            }
        }
        if (!losers.isEmpty()) {
            System.out.println("\n=============================\nПозорно сошли с дистанции: ");
            for (Trailrunnable participant : losers) {
                System.out.println(participant);
            }
        }
    }
}
