package com.example.springkadaiform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springkadaiform.form.ContactForm;

@Controller
public class ContactFormController {
	
	@GetMapping("/form")
	public String form(Model model) {

		// ビューにフォームクラスのインスタンスを渡す
		model.addAttribute("contactForm", new ContactForm());

		return "contactFormView";
	}

	// コントローラーメソッドでエラーがある場合はそのまま同じビューを返す
	@PostMapping("/confirm")
	public String confirm(
			@Validated ContactForm form, BindingResult result,Model model) {

		// バリデーションエラーがあったら終了
		if (result.hasErrors()) {
			// エラーが存在する場合、入力フォームに戻る
			return "contactFormView";
		}
		
		//引数でもらったものをそのまま渡す
		model.addAttribute("contactForm", form);
		
		// 正常に通過した場合は確認ページへ進む
		return "confirmView";
	}
}