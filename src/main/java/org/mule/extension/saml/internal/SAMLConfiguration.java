package org.mule.extension.saml.internal;

import org.mule.runtime.extension.api.annotation.Expression;
import org.mule.runtime.extension.api.annotation.Operations;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.Parameter;

import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.display.Example;
import org.mule.runtime.extension.api.annotation.param.display.Password;
import org.mule.runtime.extension.api.annotation.param.display.Path;
import org.mule.runtime.extension.api.annotation.values.OfValues;

import org.mule.runtime.api.meta.model.display.PathModel.Type;
import org.mule.runtime.api.meta.ExpressionSupport;
import org.mule.runtime.api.meta.model.display.PathModel.Location;

/**
 * This class represents an extension configuration, values set in this class are commonly used across multiple
 * operations since they represent something core from the extension.
 */
@Operations(SAMLOperations.class)
public class SAMLConfiguration {

	@Parameter
	@DisplayName("Algorithm")
	@Expression(ExpressionSupport.NOT_SUPPORTED)
	@OfValues(AlgorithmValues.class)
	private String algType;
	
	@Parameter
	@DisplayName("(JKS) KeyStore File Location")
	@Path(type = Type.FILE, acceptedFileExtensions = "jks", location = Location.EXTERNAL, acceptsUrls = false)
	private String keyStorePath;
	
	@Parameter
	@DisplayName("KeyStore Password")
	@Password
	private String keyStorePassword;
	
	@Parameter
	@DisplayName("Key Name")
	@Example("sso")
	private String keyName;
	
	@Parameter
	@DisplayName("Key Password (leave blank if same as KeyStore)")
	@Optional()
	@Password
	private String keyPassword;	

	public String getKeyName()
	{
		return keyName;
	}
	
	public String getKeyPassword()
	{
		if (keyPassword == null)
			keyPassword = keyStorePassword;
		
		return keyPassword;
	}

	public String getAlgType()
	{
		return this.algType;
	}

	public String getJavaSigType()
	{
		String sigType = SAMLConstants.sSHA256RSA;
		
		switch(this.algType)
		{
			case SAMLConstants.sRS256:
				sigType = SAMLConstants.sSHA256RSA;
				break;
			case SAMLConstants.sES256:
				sigType = SAMLConstants.sSHA256ECDSA;
				break;
		}
		return sigType;
	}
	
	public String getKeyStorePath()
	{
		return keyStorePath;
	}

	public String getKeyStorePassword()
	{
		return keyStorePassword;
	}

	public String getConfigInfo()
	{
		return "SAML Configuration";
	}
}
