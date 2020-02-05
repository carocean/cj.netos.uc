package cj.netos.uc.service;

import cj.netos.uc.model.AppAccessToken;

public interface IAppAccessTokenService {
    AppAccessToken getAccessToken(String accessToken);

    void updateAccessToken(String person, AppAccessToken appAccessToken);

}
