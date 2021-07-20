package actions;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import actions.views.ReportView;
import constants.AttributeConst;
import constants.ForwardConst;
import constants.JpaConst;
import services.ReportService;

public class ReportAction extends ActionBase {
	private ReportService service;

	@Override
	public void process() throws ServletException, IOException {

		service = new ReportService();

		//メソッドを実行
		invoke();
		service.close();
	}

	public void index() throws ServletException, IOException {
		int page = getPage();
		List<ReportView> reports = service.getAllPerPage(page);
		long reportsCount = service.countAll();
		putRequestScope(AttributeConst.REPORTS, reports); //取得した日報データ
		putRequestScope(AttributeConst.REP_COUNT, reportsCount); //全ての日報データの件数
		putRequestScope(AttributeConst.PAGE, page); //ページ数
		putRequestScope(AttributeConst.MAX_ROW, JpaConst.ROW_PER_PAGE); //1ページに表示するレコードの数
		String flush = getSessionScope(AttributeConst.FLUSH);
		if (flush != null) {
			putRequestScope(AttributeConst.FLUSH, flush);
			removeSessionScope(AttributeConst.FLUSH);
		}

		//一覧画面を表示
		forward(ForwardConst.FW_REP_INDEX);
	}
}
