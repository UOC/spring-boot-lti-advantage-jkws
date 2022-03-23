package edu.uoc.elc.spring.lti.jkws;

import edu.uoc.elc.lti.tool.Key;
import org.checkerframework.checker.units.qual.K;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Universitat Oberta de Catalunya
 * Made for the project spring-boot-lti-advantage-jkws
 */
class JwksKeyFactoryTest {
	private JwksKeyFactory sut;

	private Key key;

	@BeforeEach
	public void setUp() {
		this.sut = new JwksKeyFactory();
		this.key = Key.builder()
						.id("186670000000000146")
						.publicKey("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnkEQ9nkykON4GYASpaOk" +
										"tOSsb5THk3z/rLwF8DlT/Urg5KJ3goced1eU87khOBGitbT7y6G+3YCVgmTqso/B" +
										"Lam/stiVUwAATM9H01r+SZUd16vueTVTdNPoRdBvm12q0rBPiLkIYY6xqAVsN9gT" +
										"aXPg8bYfDiUP0Qf//wArhNdUHeej1+xGz82yUXDUvhNAPjYQRNy8zYiPLHNvp9hS" +
										"XXPWnxY6Opo3ozUu8QXF96MhSywQbHMZ3ILxyBHicCtaaqZOmio9J1KjcESnczoy" +
										"Yd1zk5z/hZtoAmz+RjXIQgNarTekkB1Mv9REmfukfoWoMmHv/SaMnVhNZc+r7vnC" +
										"owIDAQAB")
						.privateKey("MIIEpAIBAAKCAQEAnkEQ9nkykON4GYASpaOktOSsb5THk3z/rLwF8DlT/Urg5KJ3" +
										"goced1eU87khOBGitbT7y6G+3YCVgmTqso/BLam/stiVUwAATM9H01r+SZUd16vu" +
										"eTVTdNPoRdBvm12q0rBPiLkIYY6xqAVsN9gTaXPg8bYfDiUP0Qf//wArhNdUHeej" +
										"1+xGz82yUXDUvhNAPjYQRNy8zYiPLHNvp9hSXXPWnxY6Opo3ozUu8QXF96MhSywQ" +
										"bHMZ3ILxyBHicCtaaqZOmio9J1KjcESnczoyYd1zk5z/hZtoAmz+RjXIQgNarTek" +
										"kB1Mv9REmfukfoWoMmHv/SaMnVhNZc+r7vnCowIDAQABAoIBABng8AIuLYut9uzM" +
										"mcAGc5+1KVGR1dUTgsffc2UmKsrn3MDmpH5u1BeV9eCpLHp7v8zRDL/u8kRMi6Zo" +
										"FE0g3uk1sghwDHMnM+VbnBY+8ghcXyXukq+1fbFEGd6YyDdy6MVNWaQ1Bd7WM80T" +
										"HfA/4GTFM0qzin6Ipv56vW0YvQUa42MHgS51DgX2cd0D432uBqegQiNAbbydQjYG" +
										"Zfm3PPH/d9U8iEugFP0ZpTRPv38yMUrkeuiIq5wbkmomcG/gtTU/uV+AyfAxQM+D" +
										"pbV78zjET1lSfPzvPpU8h7eFcpXMqqhGYDuf+tjWONY+Ocm0y4UdYeNWW41/3+1T" +
										"DYtqc0ECgYEA0GCv+8MZPsUBwN9Iax2EFow8VXnlhm3f9HbOgEtX83lI72KJr4Sv" +
										"3s8sdU0GX8llvqV8rBhUVXT4uGncYeIOCOMqD8lqqKHR/XF2DC+DJUi65b+++GCM" +
										"FbgMUExT+0/wLPSBQ2r3lNFx3iBpDMxHpLOBAyGxzUkACTPP/4xfEiECgYEAwmvc" +
										"I6zQP780w8Mwf5DmlROtM1DdP0hYQG7HsOSznfK0f4BI20E3j1Wt2cUhZTPcV/GU" +
										"mFrRlX7BCG36ZBkKHG3Iw+8OtUuYXlCuhULc/b7UDsGMtUv9lbBfp09xPbxGVZEh" +
										"YeK2M41gYK7dGKQ03AMY2GR908GqqtWOMCLfhEMCgYEAwDQO32hrxsws+9x4jeTh" +
										"y3J6zFTtc3uxkWpsu0XD0F5U+gmn+m+nURtDZMcxU/UOljVKs+qVD2YfbOqoTtkW" +
										"HPh7+afNa9InQWEAg+jnTOKzEew1mCBl1jq3kPF2nV50qOK2wJrP10MBhuPaQeXD" +
										"R5YTL/JKcJIfKF3UQ2EU6EECgYEAq+DTAy76BAEz0oUy0PP3BYAZtK4eip2Yd434" +
										"OChXqqEwdS+iOUOUrMDgKw+dkGyitZS6+13+vx0J5jvkCq4gRDXCMYWcCSbFk0vc" +
										"na8Y07Lqogj2Lij6DGWair0urZdOzsK5MmJNFZI8y/yLNgelO4P5aQSeQKCMEu8s" +
										"/t01oSUCgYBacilkDrT2HNyd6T5DATVIiqM0DYYjsqGvoaFRluRe138CaYg4rruM" +
										"2a9j1xwlO/Z2IIUiJd1our5TVgColTmarRhh1CWYYRbnMC7azFFHr0A4pvxcxoU9" +
										"mKS4HeZAucP4uMGYRMQywVivmJtFL3qdaD/VlEf/4tCbvNCL9vd58w==")
						.algorithm("RSA")
						.build();
	}

	@Test
	void from() {
		final JwksKey jwksKey = sut.from(key);
		assertNotNull(jwksKey);
		assertEquals("RSA", jwksKey.getKty());
		assertEquals("RS256", jwksKey.getAlg());
		assertEquals("sig", jwksKey.getUse());
		assertEquals("AQAB", jwksKey.getE());
		assertEquals("186670000000000146", jwksKey.getKid());
		assertEquals("AJ5BEPZ5MpDjeBmAEqWjpLTkrG-Ux5N8_6y8BfA5U_1K4OSid4KHHndXlPO5ITgRorW0-8uhvt2AlYJk6rKPwS2pv7LYlVMAAEzPR9Na_kmVHder7nk1U3TT6EXQb5tdqtKwT4i5CGGOsagFbDfYE2lz4PG2Hw4lD9EH__8AK4TXVB3no9fsRs_NslFw1L4TQD42EETcvM2Ijyxzb6fYUl1z1p8WOjqaN6M1LvEFxfejIUssEGxzGdyC8cgR4nArWmqmTpoqPSdSo3BEp3M6MmHdc5Oc_4WbaAJs_kY1yEIDWq03pJAdTL_URJn7pH6FqDJh7_0mjJ1YTWXPq-75wqM=", jwksKey.getN());
	}
}