package com.dsc.indices.reviewservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import se.magnus.api.core.review.Review;
import se.magnus.api.core.review.ReviewService;
import se.magnus.util.http.ServiceUtil;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ReviewServiceImpl implements ReviewService {

    private ServiceUtil serviceUtil;

    @Autowired
    public ReviewServiceImpl(ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
    }

    @Override
    public List<Review> getReviews(int productId) {
        ArrayList<Review> reviews= new ArrayList<Review>(){};

        reviews.add(new Review(productId,1,"Author 1","Review 1","Best Proudct Ever 1", serviceUtil.getServiceAddress()));
        reviews.add(new Review(productId,2,"Author 2","review 2","Best Proudct Ever 2", serviceUtil.getServiceAddress()));
        reviews.add(new Review(productId,3,"Author 3","Review 3","Best Proudct Ever 3", serviceUtil.getServiceAddress()));

        return reviews;
    }
}
