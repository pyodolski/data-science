package com.example.validation.dto;

import java.util.ArrayList;
import java.util.List;

public class ErrorResDto {
    /*
    * {
	      // "response":"Http Bad Request",
	      //  "errors":[
		    //    {"field":"age", "msg":"110이하여야 합니다."},
		    //    {"field":"age", "msg":"110이하여야 합니다."}
	      //  ]
        //}
    * */

    private String response;
    private List<Error> errors = new ArrayList<>();

    public ErrorResDto(){}
    public ErrorResDto(Builder builder) {
        this.response = builder.response;
        this.errors = builder.errors;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    public void addError(Error error) {
        errors.add(error);
    }

    public static Builder builder() {
        return new ErrorResDto.Builder();
    }

    @Override
    public String toString() {
        return "ErrorResDto{" +
                "response='" + response + '\'' +
                ", errors=" + errors +
                '}';
    }

    public static class Builder {
        private String response;
        private List<Error> errors = new ArrayList<>();

        public Builder response(String response) {
            this.response = response;
            return this;
        }

//        public Builder errors(List<Error> errors) {
//            this.errors = errors;
//            return this;
//        }
//
//        public Builder error(Error error) {
//            errors.add(error);
//            return this;
//        }

        public ErrorResDto build() {
            return new ErrorResDto(this);
        }
    }

    public static class Error {
        private String field;
        private String msg;

        public Error(){}
        public Error(Builder builder) {
            this.field = builder.field;
            this.msg = builder.msg;
        }
        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public static Builder builder() {
            return new ErrorResDto.Error.Builder();
        }

        @Override
        public String toString() {
            return "Error{" +
                    "field='" + field + '\'' +
                    ", msg='" + msg + '\'' +
                    '}';
        }

        public static class Builder {
            private String field;
            private String msg;

            public Builder field(String field) {
                this.field = field;
                return this;
            }

            public Builder msg(String msg) {
                this.msg = msg;
                return this;
            }

            public Error build() {
                return new Error(this);
            }
        }
    }
}
