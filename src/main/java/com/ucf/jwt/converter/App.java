package com.ucf.jwt.converter;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.ucf.jwt.converter.impl.JwtTokenConverterImpl;

import io.jsonwebtoken.Claims;

public class App {
	private static String SECRET_KEY =
			 "oeRaYY7Wo24sDqKSX3IM9ASGmdGPmkTd9jo1QTy4b7P9Ze5_9hKolVX8xNrQDcNRfVEdTZNOuOyqEGhXEbdJI-ZQ19k_o9MI0y3eZN2lp9jow55FfXMiINEdt1XR85VipRLSOkT6kSpzs2x-jbLDiz9iFVzkd81YKxMgPA7VfZeQUm4n-mOmnWMaVX30zGFU4L3oPBctYKkl4dYfqYWqRNfrgPJVi5DGFjywgxx0ASEiJHtV72paI3fDR2XwlSkyhhmY-ICjCRmsJN4fX1pdoL8a18-aQrvyu4j0Os6dVPYIoPvvY0SAZtWYKHfM15g7A3HD4cVREf9cUsprCRK93w";

	public static void main(String[] args) {
		JwtTokenConverter converter=new JwtTokenConverterImpl();
		Map<String, Object> map=new HashMap<String, Object>();
		String token=converter.createJWT("1", "msi", "n/a", map, new Date().getTime(), SECRET_KEY);
		
		System.out.print(converter.decodeJWT(token, SECRET_KEY));		
	}

}
