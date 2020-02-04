package cj.netos.uc.service;

import cj.netos.uc.model.AppRefreshToken;

public interface IAppRefreshTokenService {
    AppRefreshToken updateRefreshToken(String person);

    AppRefreshToken getRefreshToken(String refreshToken);
}
