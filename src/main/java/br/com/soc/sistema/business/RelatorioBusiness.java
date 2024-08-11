package br.com.soc.sistema.business;

import br.com.soc.sistema.vo.ExameDeFuncionarioVo;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class RelatorioBusiness {
    public void montarArquivo(List<ExameDeFuncionarioVo> exames) {
        try (XSSFWorkbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Relatório de Exames");

            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("ID Funcionário");
            headerRow.createCell(1).setCellValue("Nome Funcionário");
            headerRow.createCell(2).setCellValue("ID Exame");
            headerRow.createCell(3).setCellValue("Nome Exame");
            headerRow.createCell(4).setCellValue("Data de Realização");

            int rowNum = 1;
            for (ExameDeFuncionarioVo exame : exames) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(exame.getFuncionarioId());
                row.createCell(1).setCellValue(exame.getFuncionarioNome());
                row.createCell(2).setCellValue(exame.getRowid());
                row.createCell(3).setCellValue(exame.getNome());
                row.createCell(4).setCellValue(exame.getData().toString());
            }

            for (int i = 0; i < 5; i++) {
                sheet.autoSizeColumn(i);
            }

            HttpServletResponse response = ServletActionContext.getResponse();
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Disposition", "attachment; filename=relatorio_exames.xlsx");

            workbook.write(response.getOutputStream());
            response.getOutputStream().flush();
            response.getOutputStream().close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
