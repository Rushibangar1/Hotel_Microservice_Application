package com.app.Rating.RatingService.Exception;





public class ResourceNotFoundException extends  Exception{

    public ResourceNotFoundException(String s){
        super(s);
    }

    public ResourceNotFoundException(){
        super("Resource Not Found ");
    }

}
