package com.ex.WebApplication.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ex.WebApplication.model.CSVModel;

@RestController
public class CSVController {

	private static String fileName = " CSV File Name";

	@GetMapping("/csvServices")
	public @ResponseBody List<CSVModel> csvServices() {
		List<CSVModel> readCSVs = new ArrayList<CSVModel>();
		try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
			String str;

			while ((str = in.readLine()) != null) {
				String[] tokens = str.split(",");
				String name = tokens[0];
				String name1 = tokens[1];
				String name2 = tokens[2];
				String name3 = tokens[3];
				CSVModel csv = new CSVModel();
				csv.setFirstName(name);
				csv.setId(name3);
				csv.setId2(name1);
				csv.setLastName(name2);
				readCSVs.add(csv);
			}

			System.out.println(readCSVs);

		} catch (Exception e) {
			System.out.println("File Read Error");
		}

		return readCSVs;
	}

	@GetMapping("/viewCSV")
	public ModelAndView getCSV() {
		ModelAndView csvdata = new ModelAndView("csvData");
		List<CSVModel> readCSVs = new ArrayList<CSVModel>();
		try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
			String str;

			CSVModel csv = new CSVModel();
			while ((str = in.readLine()) != null) {
				String[] tokens = str.split(",");
				String name = tokens[0];
				String name1 = tokens[1];
				String name2 = tokens[2];
				String name3 = tokens[3];
				csv.setFirstName(name);
				csv.setId(name3);
				csv.setId2(name1);
				csv.setLastName(name2);
				readCSVs.add(csv);
			}
			csvdata.addObject("csvfile", readCSVs);
			System.out.println(readCSVs);

		} catch (Exception e) {
			System.out.println("File Read Error");
		}

		return csvdata;
	}

}
