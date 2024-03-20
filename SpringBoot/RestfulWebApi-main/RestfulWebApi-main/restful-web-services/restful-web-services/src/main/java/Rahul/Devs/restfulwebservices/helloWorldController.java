package Rahul.Devs.restfulwebservices;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloWorldController {

    private MessageSource messageSource;

    public helloWorldController(MessageSource messageSource){
        this.messageSource =messageSource;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    public String helloWorld(){
        return "how's it going";
    }
    

    @RequestMapping(method = RequestMethod.GET, path = "/helloworldbean")
    public Helloworldbean helloworldbean(){
        return new Helloworldbean("Hello WOrld");
    }

    @RequestMapping(method = RequestMethod.GET, path = "/helloworld/{name}")
    public Helloworldbean helloWorldPathVariable(@PathVariable String name){
        return new Helloworldbean(String.format("Hello %s",name));
    }
    @RequestMapping(method = RequestMethod.GET, path = "/hello-world-Internationalization")
    public String helloWorldInternational(){
        Locale locale = LocaleContextHolder.getLocale();
        return  messageSource.getMessage("good.morning.message", null, "Default Message", locale);
    }
}
