package com.dsc.indices.recommendationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import se.magnus.api.core.recommendation.Recommendation;
import se.magnus.api.core.recommendation.RecommendationService;
import se.magnus.util.exceptions.InvalidInputException;
import se.magnus.util.exceptions.NotFoundException;
import se.magnus.util.http.ServiceUtil;


import java.util.ArrayList;
import java.util.List;

@RestController
public class RecommendationServiceServiceImpl implements RecommendationService {

    private ServiceUtil serviceUtil;

    @Autowired
    public RecommendationServiceServiceImpl(ServiceUtil serviceUtil) {

        this.serviceUtil = serviceUtil;
    }


    @Override
    public List<Recommendation> getRecommendations(int productId) {

        if (productId < 1) throw new InvalidInputException("Invalid productId:" + productId);
        if (productId == 13) throw new NotFoundException("No product found for productId: " + productId);

        ArrayList<Recommendation> recommendations= new ArrayList<Recommendation>(){};

        recommendations.add(new Recommendation(productId,1,"Author 1",5,"Best Proudct Ever 1", serviceUtil.getServiceAddress()));
        recommendations.add(new Recommendation(productId,2,"Author 2",5,"Best Proudct Ever 2", serviceUtil.getServiceAddress()));
        recommendations.add(new Recommendation(productId,3,"Author 3",5,"Best Proudct Ever 3", serviceUtil.getServiceAddress()));

        return recommendations;
    }
}
