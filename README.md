# SAML Extension for Mule 4.x

### Overview 
Mule 4.x extension for SAML. Extension allows you to perform the following operations

- Generate AuthNRequest
- Validate SAMLResponse

#### Generate AuthNRequest

Operation generates a deflated and encoded XML. You can use online tool like [SAML Tool](https://www.samltool.com/decode.php) to base64 decode and inflate the intercepted SAML Message. See the example below.

```
<?xml version="1.0" encoding="UTF-8"?>
<samlp:AuthnRequest AssertionConsumerServiceURL="http://localhost:8081/test" 
Destination="<IdP Login URL>" 
ID="2b5eed1f-a11c-4b64-86e6-64de7452af62" 
IssueInstant="2020-12-07T18:53:12.903Z" 
ProtocolBinding="urn:oasis:names:tc:SAML:2.0:bindings:HTTP-POST" 
Version="2.0" xmlns:samlp="urn:oasis:names:tc:SAML:2.0:protocol">
    <saml2:Issuer xmlns:saml2="urn:oasis:names:tc:SAML:2.0:assertion">mule.saml.example</saml2:Issuer>
    <saml2p:NameIDPolicy AllowCreate="true" Format="urn:oasis:names:tc:SAML:2.0:nameid-format:persistent" xmlns:saml2p="urn:oasis:names:tc:SAML:2.0:protocol" />
</samlp:AuthnRequest>
```

### Install 
Add this dependency to your application pom.xml

```
<groupId>com.dejim</groupId>
<artifactId>saml</artifactId>
<version>1.0.0-SNAPSHOT</version>
<classifier>mule-plugin</classifier>
```
