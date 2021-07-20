package actions.views;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter //全てのクラスフィールドについてgetterを自動生成する(Lombok)
@Setter //全てのクラスフィールドについてsetterを自動生成する(Lombok)
@NoArgsConstructor //引数なしコンストラクタを自動生成する(Lombok)
@AllArgsConstructor //全てのクラスフィールドを引数にもつ引数ありコンストラクタを自動生成する(Lombok)
public class ReportView {
	private Integer id;
	private EmployeeView employee;
	private LocalDate reportDate;
	private String title;
	private String content;

	/**
	 * 登録日時
	 */
	private LocalDateTime createdAt;

	/**
	 * 更新日時
	 */
	private LocalDateTime updatedAt;
}
