package proj.qr_attendance_system;

import okhttp3.*;

public class ApiClient {
    private static final String BASE_URL = "https://qr-backend-production-6749.up.railway.app";

    private static final OkHttpClient client = new OkHttpClient();


    public static String facultyLogin(String email, String password) throws Exception {
        String json = "{ \"email\":\"" + email + "\", \"password\":\"" + password + "\" }";

        RequestBody body = RequestBody.create(json, MediaType.get("application/json"));
        Request request = new Request.Builder()
                .url(BASE_URL + "/auth/facultyLogin")
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            assert response.body() != null;
            return response.body().string();
        }
    }

    public static String addFaculty(String email, String password) throws Exception {
        String json = "{ \"email\":\"" + email + "\", \"password\":\"" + password + "\" }";

        RequestBody body = RequestBody.create(json, MediaType.get("application/json"));
        Request request = new Request.Builder()
                .url(BASE_URL + "/admin/addFaculty")
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            assert response.body() != null;
            return response.body().string();
        }
    }

    public static String addStudent(String name, String email) throws Exception {
        String json = "{ \"name\":\"" + name + "\", \"email\":\"" + email + "\"}";

        RequestBody body = RequestBody.create(json, MediaType.get("application/json"));
        Request request = new Request.Builder()
                .url(BASE_URL + "/admin/addStudent")
                .post(body)
                .build();

        try(Response response = client.newCall(request).execute()) {
            assert response.body() != null;
            return response.body().string();
        }
    }
}
