package com.lieying.user.service.impl;

import com.lieying.user.entity.SysUser;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;

@Service(value="passwordHelper")
public class PasswordHelper {

    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
    //private String algorithmName = "md5";
    private int hashIterations = 2;

    public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    /*public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }*/

    public void setHashIterations(int hashIterations) {
        this.hashIterations = hashIterations;
    }

    public void encryptPassword(SysUser user) {

        user.setSalt(randomNumberGenerator.nextBytes().toHex());

        String newPassword = new Md5Hash(
                user.getPassword(),
                ByteSource.Util.bytes(user.getCredentialsSalt()),
                hashIterations).toHex();

        user.setPassword(newPassword);
    }
    
    public String getPassword(String salt,String userName,String password) {


        String newPassword = new Md5Hash(
                password,
                ByteSource.Util.bytes(userName + salt),
                hashIterations).toHex();

        return newPassword;
    }
    
    public void encryptPasswordTest(SysUser user) {


        String newPassword = new Md5Hash(
                user.getPassword(),
                ByteSource.Util.bytes(user.getCredentialsSalt()),
                hashIterations).toHex();
        user.setPassword(newPassword);
    }
    
    public static void main(String[] args) {
    	// RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
    	 //String salt = randomNumberGenerator.nextBytes().toHex();
    	// System.out.println("salt is " +salt);
    	 
    	String salt = "023a01d084e82fcfb5f7f26b100a91cf";
    			//randomNumberGenerator.nextBytes().toHex();
    	System.out.println("salt is " + salt);
    	String username = "lyAdmin";
    	String newPassword = new Md5Hash(
                "lyBrowser123",
                ByteSource.Util.bytes(username+salt),
                2).toHex();
    	System.out.println("newPassword is " + newPassword);
    }
}
