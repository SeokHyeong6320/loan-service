package com.project.loanservice.swagger;

import com.project.loanservice.domain.Organization;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.lang.annotation.*;


public @interface Swagger {

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @Inherited
    @Operation(summary = "상품 정보 조회 API", description = "상품 정보를 조회하는 API")
    @Parameter(name = "organizationCode", description = "기관 코드", schema = @Schema(implementation = Organization.class), required = true)
    @ApiResponse(responseCode = "200", content = @Content(examples = @ExampleObject(value = """
            {
                "data": [
                    {
                        "organizationCode": "00001",
                        "productCode": "001",
                        "productMaximumInterest": 9.9,
                        "productMinimumInterest": 1.1,
                        "productName": "상품 1"
                    }
                ],
                 "responseCode": "00",
                 "responseMessage": "success"
            }
            """)))
    @interface GetProductInfo {
        // com.project.loanservice.controller.impl.ProductControllerImpl
    }


    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @Inherited
    @Operation(summary = "상품 정보 수신 API", description = "금융사로부터 상품 정보를 받는 API")
    @RequestBody(content = @Content(examples = @ExampleObject(value = """
            {
                "organizationCode": "00001",
                "productCode": "001",
                "productMaximumInterest": 9.9,
                "productMinimumInterest": 1.1,
                "productName": "상품 1"
            }
            """)))
    @ApiResponse(responseCode = "200", content = @Content(examples = @ExampleObject(value = """
            {
               "responseCode": "00",
               "responseMessage": "success"
            }
            """)))
    @interface ObtainProductInfo {
        // com.project.loanservice.controller.impl.ProductControllerImpl
    }


    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @Inherited
    @Operation(summary = "유저 정보 수신 API", description = "유저 정보를 받는 API")
    @RequestBody(content = @Content(examples = @ExampleObject(value = """
            {
                 "userIncomeAmount": 100000,
                 "userName": "백엔드", "userRegistrationNumber": "900101-1234567"
            }
            """)))
    @ApiResponse(responseCode = "200", content = @Content(examples = @ExampleObject(value = """
            {
             "data": {
                    "userKey": "2cbd0d0ee3bc460e94979e451210bedb"
               },
               "responseCode": "00",
               "responseMessage": "success"
            }
            """)))
    @interface ObtainUserInfo {
        // com.project.loanservice.controller.impl.UserControllerImpl
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @Inherited
    @Operation(summary = "유저 정보 조회 API", description = "유저 정보를 조회하는 API")
    @Parameter(name = "userKey", description = "userKey-userKey", required = true)
    @ApiResponse(responseCode = "200", content = @Content(examples = @ExampleObject(value = """
            }
                 "data": {
                      "userKey": "2cbd0d0ee3bc460e94979e451210bedb",
                      "userRegistrationNumber": "900101-1234567"
                    },
                    "responseCode": "00",
                    "responseMessage": "success"
                  }
            """)))
    @interface GetUserInfo {
        // com.project.loanservice.controller.impl.UserControllerImpl
    }




}
