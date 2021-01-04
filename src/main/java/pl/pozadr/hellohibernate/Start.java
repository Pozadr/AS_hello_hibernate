package pl.pozadr.hellohibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.pozadr.hellohibernate.model.Color;
import pl.pozadr.hellohibernate.model.Sail;
import pl.pozadr.hellohibernate.repository.SailRepo;

@Component
public class Start {
    private SailRepo sailRepo;

    @Autowired
    public Start(SailRepo sailRepo) {
        this.sailRepo = sailRepo;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        Sail sailSimmer = new Sail("Simmer", "Blacktip", Color.BLUE);
        Sail sailGoya = new Sail("Goya", "Banzai", Color.YELLOW);
        sailRepo.save(sailSimmer);
        sailRepo.save(sailGoya);

        System.out.println("\nAll sails:");
        sailRepo.findAll().forEach(System.out::println);

        System.out.println("\nFind by Color:");
        sailRepo.findByColor(Color.BLACK).forEach(System.out::println);

        System.out.println("\nFind by Color and mark:");
        sailRepo.findByColorAndMark(Color.BLACK, "Duotone").forEach(System.out::println);

        System.out.println("\nFind by mark:");
        sailRepo.findByMarkMyImpl("Severne").forEach(System.out::println);
    }
}
