package com.bliepy.level_6_task_2.common

import com.bliepy.level_6_task_2.BuildConfig
import okhttp3.*

class ApiMockInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        if (BuildConfig.DEBUG) {

            val path = chain.request().url.toUri().toString()
            val responseString = MovieDbMockService().getMockedJsonResponse(path)

            return chain.proceed(chain.request())
                .newBuilder()
                .code(200)
                .protocol(Protocol.HTTP_2)
                .message(responseString)
//                .body(
//                    ResponseBody.create(
//                        MediaType.parse("application/json"),
//                        responseString.toByteArray()
//                    )
//                )
                .addHeader("content-type", "application/json")
                .build()
        } else {
            throw IllegalAccessError("MockInterceptor is only meant for Testing Purposes and bound to be used only with DEBUG mode"
            )
        }
    }
}
