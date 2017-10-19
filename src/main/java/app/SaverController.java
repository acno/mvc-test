package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;

@RestController
public class SaverController {
    private final FileSaver fileSaver;

    @Autowired
    public SaverController(FileSaver fileSaver) {
        this.fileSaver = fileSaver;
    }

    @GetMapping("/save")
    public @ResponseBody String save(@RequestParam(name="message") String message) {
        fileSaver.save(message);
        return String.format("Message \"%s\" saved", message);
    }

    @GetMapping("/read")
    public @ResponseBody LinkedList<String> read() {
        return fileSaver.read();
    }
}
