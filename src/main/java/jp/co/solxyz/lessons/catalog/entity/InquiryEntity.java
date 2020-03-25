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

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -756435552638981666L;

	private String id;

	private String name;

	private String company;

	private String phone;

	private String mail;
}
