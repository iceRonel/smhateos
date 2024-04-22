package org.rk.smhateos.institutions.web;

import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class InstitutionController {


    @GetMapping("/test")

    public ResponseEntity<?> test(){
        var p = new Person("Ronel","kontchou",true);
        PersonModel model = new PersonModel(p);

        Link link = Link.of("http://localhost:8080/test/{segment}/api/{?parameter}", IanaLinkRelations.NEXT);

        model.add(link.expand(Map.of("segment","path","parameter",42)));

        return ResponseEntity.ok(model);
    }
}
