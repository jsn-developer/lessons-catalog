package jp.co.solxyz.lessons.catalog.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * 問い合わせ情報
 * @author HISATO
 *
 */
@Data
public class InquiryEntity implements Serializable{


	private String id;

	private String name;

	private String company;

	private String phone;

	private String mail;
}
