package payments;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

/*    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Payments greeting(@RequestParam(value="name", defaultValue="Emmeline") String name) {
        return new Payments(counter.incrementAndGet(),
                            String.format(template, name));
    }*/

    @RequestMapping("/pay")
    public Payments pay(@RequestParam(value="uid") String uid) {
        return new Payments(String.format(uid));
    }
}
