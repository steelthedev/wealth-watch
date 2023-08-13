package dev.steelthedev.WealthWatch.API.Investment.Controller;

import dev.steelthedev.WealthWatch.API.Investment.Model.InvestmentRequest;
import dev.steelthedev.WealthWatch.API.Investment.Services.InvestmentServices;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/investment")
public class InvestmentController {


        private final InvestmentServices investmentServices;

        public InvestmentController(InvestmentServices investmentServices) {
                this.investmentServices = investmentServices;
        }

        @PostMapping("/invest/buy/{id}")
        @PreAuthorize("hasRole('USER')")
        @ResponseStatus(value = HttpStatus.ACCEPTED,reason = "success")
        public void invest(@PathVariable Long id, @RequestBody InvestmentRequest investmentRequest){
                investmentServices.buy(id,investmentRequest);
        }


}
