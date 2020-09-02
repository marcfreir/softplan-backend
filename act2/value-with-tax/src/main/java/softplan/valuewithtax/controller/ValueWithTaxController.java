package softplan.valuewithtax.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import softplan.valuewithtax.models.PostRequest;
import softplan.valuewithtax.models.PostResponse;

@RestController
public class ValueWithTaxController {

    @RequestMapping(value = "/valuewithtax", method = RequestMethod.POST)
    public PostResponse ValueWithTax(@RequestBody PostRequest inputPayload) {
        PostResponse response = new PostResponse();
        response.setValueWithTax((inputPayload.getTax() * inputPayload.getAmount() / 100) + (inputPayload.getAmount()));
        return response;
    }

}
