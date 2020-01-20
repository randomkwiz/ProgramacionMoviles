package es.iesnervion.avazquez.amorometro;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface APILoveMeter {
    @Headers({
            "X-RapidAPI-Host: love-calculator.p.rapidapi.com",
            "X-RapidAPI-Key: d1d704092dmshb5507c0fd0d1603p19bd5bjsn586552909421",
            "Content-Type: application/json"
    })

    @GET("/getPercentage")
    Call<JSONObjectLoveM> getResultadoLoveMeter(@Query("fname") String fname,
                                                @Query("sname") String sname);
}
