package com.test.nb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;import javax.print.DocFlavor.STRING;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.nb.domain.CommentDto;
import com.test.nb.service.CommentDeleteService;
import com.test.nb.service.CommentInsertService;
import com.test.nb.service.CommentListService;
import com.test.nb.service.InsertService;

@RestController
@RequestMapping("/rest/comment")
public class CommentController {
	
	@Autowired
	CommentInsertService InsertService;
	@Autowired
	CommentListService listService;
	@Autowired
	CommentDeleteService deleteService;
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<String> insertCm(
			CommentDto cDto
			) {
		int rCnt=0;
		System.out.println("댓글체크>>"+cDto.toString());
		rCnt=InsertService.insertComment(cDto);
		return new ResponseEntity<String>(rCnt>0?"success":"fail",HttpStatus.OK);
	}
	@CrossOrigin
	@PostMapping("/re")
	public ResponseEntity<String> insertReCm(
			CommentDto cDto
			) {
		int rCnt=0;
		System.out.println("답글체크>>"+cDto.toString());
		rCnt=InsertService.insertReComment(cDto);
		return new ResponseEntity<String>(rCnt>0?"success":"fail",HttpStatus.OK);
	}
	@CrossOrigin
	@GetMapping("/cList/{idx}")
	public ResponseEntity<List<CommentDto>> commentList(
			@PathVariable("idx")int idx
			) {
		
		List<CommentDto>list = null;
		list = listService.getCLiset(idx);
		return new ResponseEntity<List<CommentDto>>(list,HttpStatus.OK);
	}
	@CrossOrigin
	@GetMapping("/cCount/{idx}")
	public ResponseEntity<Integer> commentCount(
			@PathVariable("idx")int idx
			) {
		
		int rCnt=InsertService.commentCount(idx);
		
		return new ResponseEntity<Integer>(rCnt,HttpStatus.OK);
	}
	@CrossOrigin
	@DeleteMapping("/cDelete/{idx}")
	public ResponseEntity<String> commentDelete(
			@PathVariable("idx")int n_idx
			) {
		
		int rCnt=0;
		
		rCnt= deleteService.deleteComment(n_idx);
		return new ResponseEntity<String>(rCnt>0?"success":"fail",HttpStatus.OK);
	}

}
