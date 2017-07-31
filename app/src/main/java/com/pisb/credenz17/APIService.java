package com.pisb.credenz17;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by sabari on 30/7/17.
 */

public interface APIService {

    @FormUrlEncoded
    @POST("receipts.php")
    Call<Receipt> verifyParticipant(@Field("regID") int regID, @Field("mobile") String mobile);
}
