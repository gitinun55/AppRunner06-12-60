package com.example.apprunner;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface OrganizerAPI {

    @POST("add_event")
    Call<ResultQuery> insertEvent(@Body EventFormDB body);

    @GET("login/{email}/{password}")
    Call<ResultQuery> login(@Path("email") String username, @Path("password") String password);

    @POST("register")
    Call<ResultQuery> insertRegister(@Body userDB body);

    @GET("show_event")
    Call<List<UserListResponse>> getUserName(@Query("status") int type);

    @GET("search_event/{status}/{name_event}")
    Call<List<UserListResponse>> search_event(@Path("status") int status,@Path("name_event") String name_event);

    @GET("get_idEvent/{name_event}/{name_producer}")
    Call<ResultQuery> get_idEvent(@Path("name_event") String name_event,@Path("name_producer") String name_producer);

    @GET("check_address/{id_user}")
    Call<ResultQuery> check_address(@Path("id_user") int id_user);

    @GET("value_distance/{id_add}/{name_event}")
    Call<List<Cricketer>> value_distance(@Path("id_add") int id_add,@Path("name_event") String name_event);

    @GET("event_reg_list/{id_user}/{id_add}")
    Call<List<ResultQuery>> event_reg_list(@Path("id_user") int id_user,@Path("id_add") int id_add);

    @GET("event_list/{id_user}")
    Call<List<ResultQuery>> event_list(@Path("id_user") int id_user);

    @GET("event_organizer/{id_user}")
    Call<List<ResultQuery>> event_organizer(@Path("id_user") int id_user);

    @GET("list_name_reg_event/{id_add}")
    Call<List<ResultQuery>> list_name_reg_event(@Path("id_add") int id_add);

    @GET("show_user_event/{id_add}")
    Call<List<ResultQuery>> show_user_event(@Path("id_add")int id_add);

    @POST("add_distance")
    Call<Cricketer> insertDistance(@Body CricketerDB body);

    @POST("add_address")
    Call<ResultQuery> insertAddress(@Body AddressDB body);

    @POST("reg_event")
    Call<ResultQuery> reg_event(@Body RegEventDB body);

    @PUT("edit_ProfileUser/{id_user}")
    Call<ResultQuery> edit_ProfileUser(@Path("id_user") String id_user);

    @PUT("edit_AddressUser/{first_name}")
    Call<ResultQuery> edit_Address(@Path("first_name")String first_name);

    @POST("upload_payment")
    Call<ResultQuery> upload_payment(@Body UploadPaymentDB body);

    @GET("show_user_payment/{id_add}")
    Call<ResultQuery> show_user_payment(@Path("id_add")int id_add);

    ///****////
    @GET("setName/{id_user}")
    Call<ResultQuery> setName(@Path("id_user")int id_user);

    @PUT("approve_event/{id_reg_event}")
    Call<ResultQuery> summit_payment(@Path("id_reg_event")int id_reg_event);

    @GET("getId_reg_event/{id_user}/{id_add}")
    Call<ResultQuery> getId_reg_event(@Path("id_user")int id_user,@Path("id_add")int id_add);
}

