package com.chef.app.demo.Interfaces;

import com.chef.app.demo.DataRepository.RetroWebServices.Error.APIError;

public interface ResponseHandler {
    public void onResponse(Object obj);
    public void onError(Exception error);
}
