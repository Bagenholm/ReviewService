package org.ia.reviews;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@RestController
public class ReviewController {

    private Storage reviewStorage;
    public ReviewController(Storage reviewStorage) {
        this.reviewStorage = reviewStorage;
    }

    @GetMapping("/reviews")
    public List<Review> getAll() {
        return reviewStorage.findAll();
    }

    @GetMapping("/reviews/{id}")
    public Review getOne(@PathVariable Long id) {
        return reviewStorage.findById(id).orElseThrow( () -> new ReviewException("No review with id " + id) );
    }

    @PostMapping("/reviews")
    public Review create(@RequestBody Review review) {
        return reviewStorage.save(review);
    }

    @PostMapping("/manyreviews")
    public List<Review> addFromData(@RequestBody ReviewWrapper reviewWrapper) {

        reviewWrapper.reviews.stream().forEach( review -> reviewStorage.save(review));

        return reviewStorage.findAll();
    }


    //Populates with mock data
    @GetMapping("/manyreviews")
    public List<Review> addFromData() {

        String jsonReviews = "{\"reviews\":[" +
                "{" +
                "      \"model\": \"LG OLED55C8\"," +
                "      \"rating\": \"9\"" +
                "    }," +
                "    {" +
                "      \"model\": \"Samsung QE55Q7FN\"," +
                "      \"rating\": \"8\"" +
                "    }," +
                "    {" +
                "      \"model\": \"LG OLED65C8\"," +
                "      \"rating\": \"9\"" +
                "    }," +
                "    {" +
                "      \"model\": \"Samsung UE55NU6035\"," +
                "      \"rating\": \"8\"" +
                "      }," +
                "    {" +
                "      \"model\": \"Samsung QE65Q9FN\"," +
                "      \"rating\": \"9\"" +
                "      }," +
                "    {" +
                "      \"model\": \"Samsung UE75NU8005\"," +
                "      \"rating\": \"8\"" +
                "      }," +
                "    {" +
                "      \"model\": \"Samsung QE65Q8FN\"," +
                "      \"rating\": \"7\"" +
                "      }," +
                "    {" +
                "      \"model\": \"Samsung QE49Q6FN\"," +
                "      \"rating\": \"8\"" +
                "      }," +
                "    {" +
                "      \"model\": \"Samsung QE65Q6FN\"," +
                "      \"rating\": \"8\"" +
                "      }," +
                "    {" +
                "      \"model\": \"Sony Bravia KD-65XF9005\"," +
                "      \"rating\": \"9\"" +
                "      }," +
                "    {" +
                "      \"model\": \"Samsung QE65Q7FN\"," +
                "      \"rating\": \"6\"" +
                "      }," +
                "    {" +
                "      \"model\": \"Samsung QE82Q6FN\"," +
                "      \"rating\": \"9\"" +
                "      }," +
                "    {" +
                "      \"model\": \"Philips 32PFS6402\"," +
                "      \"rating\": \"8\"" +
                "      }," +
                "    {" +
                "      \"model\": \"Samsung QE55Q9FN\"," +
                "      \"rating\": \"6\"" +
                "      }," +
                "    {" +
                "      \"model\": \"Samsung UE65NU6025\"," +
                "      \"rating\": \"7\"" +
                "      }," +
                "    {" +
                "      \"model\": \"Panasonic TX-55FZ800E\"," +
                "      \"rating\": \"9\"" +
                "      }," +
                "    {" +
                "      \"model\": \"Samsung UE55NU7305\"," +
                "      \"rating\": \"8\"" +
                "      }," +
                "    {" +
                "      \"model\": \"Philips 43PFT5503\"," +
                "      \"rating\": \"7\"" +
                "      }," +
                "    {" +
                "      \"model\": \"Sony Bravia KD-55XF9005\"," +
                "      \"rating\": \"8\"" +
                "      }," +
                "    {" +
                "      \"model\": \"Toshiba 49U6763DB\"," +
                "      \"rating\": \"8\"" +
                "      }," +
                "    {" +
                "      \"model\": \"Sony Bravia KD-65AF9\"," +
                "      \"rating\": \"8\"" +
                "      }," +
                "    {" +
                "      \"model\": \"Samsung QE75Q9FN\"," +
                "      \"rating\": \"8\"" +
                "      }," +
                "    {" +
                "      \"model\": \"Panasonic TX-55FX780E\"," +
                "      \"rating\": \"9\"" +
                "      }," +
                "    {" +
                "      \"model\": \"LG OLED65E8\"," +
                "      \"rating\": \"8\"" +
                "      }," +
                "    {" +
                "      \"model\": \"Samsung UE55NU7105\"," +
                "      \"rating\": \"6\"" +
                "      }," +
                "    {" +
                "      \"model\": \"LG OLED55B8\"," +
                "      \"rating\": \"8\"" +
                "      }," +
                "    {" +
                "      \"model\": \"Philips 65OLED873\"," +
                "      \"rating\": \"8\"" +
                "      }," +
                "    {" +
                "      \"model\": \"Samsung QE75Q8DN\"," +
                "      \"rating\": \"8\"" +
                "      }," +
                "    {" +
                "      \"model\": \"LG OLED65B8\"," +
                "      \"rating\": \"8\"" +
                "      }," +
                "    {" +
                "      \"model\": \"Samsung UE65NU8005\"," +
                "      \"rating\": \"8\"" +
                "      }," +
                "    {" +
                "      \"model\": \"Philips 55PUS8303\"," +
                "      \"rating\": \"7\"" +
                "      }," +
                "    {" +
                "      \"model\": \"Philips 55PUS6803\"," +
                "      \"rating\": \"7\"" +
                "      }," +
                "    {" +
                "      \"model\": \"Samsung QE55Q8DN\"," +
                "      \"rating\": \"7\"" +
                "      }," +
                "    {" +
                "      \"model\": \"Samsung UE65NU8045\"," +
                "      \"rating\": \"7\"" +
                "      }," +
                "    {" +
                "      \"model\": \"Philips 75PUS7803\"," +
                "      \"rating\": \"8\"" +
                "      }," +
                "    {" +
                "      \"model\": \"Samsung UE49NU7105\"," +
                "      \"rating\": \"7\"" +
                "      }," +
                "    {" +
                "      \"model\": \"Philips 43PUS6703\"," +
                "      \"rating\": \"7\"" +
                "      }," +
                "    {" +
                "      \"model\": \"Philips 55OLED803\"," +
                "      \"rating\": \"8\"" +
                "      }," +
                "    {" +
                "      \"model\": \"LG 70UK6950\"," +
                "      \"rating\": \"5\"" +
                "      }," +
                "    {" +
                "      \"model\": \"Sony Bravia KD-65AF8\"," +
                "      \"rating\": \"8\"" +
                "      }," +
                "    {" +
                "      \"model\": \"LG 65SK8500\"," +
                "      \"rating\": \"8\"" +
                "      }," +
                "    {" +
                "      \"model\": \"LG 55UK6300\"," +
                "      \"rating\": \"8\"" +
                "      }," +
                "    {" +
                "      \"model\": \"Samsung QE55Q6FN\"," +
                "      \"rating\": \"8\"" +
                "      }," +
                "    {" +
                "      \"model\": \"Hitachi 55HL9000G\"," +
                "      \"rating\": \"8\"" +
                "      }," +
                "    {" +
                "      \"model\": \"Samsung UE50NU6025\"," +
                "      \"rating\": \"6\"" +
                "      }," +
                "    {" +
                "      \"model\": \"Sony Bravia KD-49XF9005\"," +
                "      \"rating\": \"8\"" +
                "      }," +
                "    {" +
                "      \"model\": \"LG 55UK6400\"," +
                "      \"rating\": \"8\"" +
                "      }," +
                "    {" +
                "      \"model\": \"Philips 65OLED903\"," +
                "      \"rating\": \"9\"" +
                "      }," +
                "    {" +
                "      \"model\": \"LG OLED77C8\"," +
                "      \"rating\": \"8\"" +
                "     }" +
                "]}";

        ObjectMapper mapper = new ObjectMapper();
        ReviewWrapper wrapper;

        try {
            wrapper = mapper.readValue(jsonReviews, ReviewWrapper.class);
            wrapper.reviews.stream().forEach( review -> reviewStorage.save(review));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return reviewStorage.findAll();
    }

}
