package com.example.veradebora.dds.api;

import com.example.veradebora.dds.pojo.BillingHistoryResponse;
import com.example.veradebora.dds.pojo.LoginResponse;
import com.example.veradebora.dds.pojo.TopUpHistoResponse;
import com.example.veradebora.dds.pojo.TopUpRequest;
import com.example.veradebora.dds.pojo.UserSaldo;
import com.example.veradebora.dds.pojo.UserVmList;
import com.example.veradebora.dds.pojo.VmRequest;
import com.example.veradebora.dds.pojo.VoucherHistoResponse;
import com.example.veradebora.dds.pojo.VoucherResponse;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Vera Debora on 7/5/2018.
 */

public interface JsonPlaceHolderApi {

    //login EndPoint
    @FormUrlEncoded
    @POST("apiUser/loginAdmin")
    Observable<LoginResponse> LoginRequest(@Field("email") String email,
                                           @Field("password") String password);

    //RequestTopUp EndPoint
    @FormUrlEncoded
    @POST("apiBilling/topUp")
    Observable<TopUpRequest> TOP_UP_REQUEST_OBSERVABLE (@Field("amount") int amount,
                                                        @Field("id_user") int id_user,
                                                        @Field("name_bank_account") String name_bank_account,
                                                        @Field("email") String email,
                                                        @Field("name") String name,
                                                        @Field("no_rekening") int no_rekening);

    //VoucherTopUp EndPoint
    @FormUrlEncoded
    @POST("apiVoucher/useVoucher")
    Observable<VoucherResponse> VOUCHER_RESPONSE_OBSERVABLE (@Field("code") String code,
                                                             @Field("id_user") int id_user);


    //RequestVm Endpoint
    @FormUrlEncoded
    @POST("apiUserManageVm/vmRequest")
    Observable<VmRequest> VM_REQUEST_OBSERVABLE (@Field("user_name") String username,
                                                 @Field("id_user") int id_user,
                                                 @Field("image") String image,
                                                 @Field("flavor") String flavor,
                                                 @Field("hostname") String hostname,
                                                 @Field("email") String email);

    //GetUserSaldo EndPoint
    @GET("apiUsersSaldo/usersSaldo")
    Observable<UserSaldo> USER_SALDO_OBSERVABLE (@Query("id_user") String Id);

    //GetUserVM EndPoint
    @GET("apiUserManageVm/vm")
    Observable<UserVmList> USER_VM_LIST (@Query("id_user") String Id);


    //BillingHistroy EndPoint
    @GET("apiTransaction/transaction")
    Observable<BillingHistoryResponse> BILLING_HISTORY_RESPONSE_OBSERVABLE (@Query("id_user") String Id);


    //TopUpHistory Endpoint
    @GET("apiBilling/billingHistory")
    Observable<TopUpHistoResponse> TOP_UP_HISTO_RESPONSE_OBSERVABLE (@Query("id_user") String id);

    //VoucherHistory Endpoint
    @GET("apiVoucher/voucher")
    Observable<VoucherHistoResponse> VOUCHER_HISTO_RESPONSE_OBSERVABLE (@Query("id_user") String id);



}
