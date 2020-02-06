package cj.netos.uc.service;

import cj.netos.uc.model.AppRefreshToken;

public interface IAppRefreshTokenService {
    AppRefreshToken updateRefreshToken(String person,String device);

    AppRefreshToken getRefreshToken(String refreshToken);
}
