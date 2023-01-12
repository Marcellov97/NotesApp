import {Component, OnInit} from '@angular/core';
import {Post} from "../../model/post";
import {PostService} from "../../service/post.service";
import { NgForm} from "@angular/forms";
import {Router} from "@angular/router";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})


export class HomeComponent implements OnInit {
  //selectedPost? : Post;
  posts : Post[] = [];

  constructor(private postService : PostService, private router: Router) {
  }

  getPosts():void {
    this.postService.getAllPosts().subscribe((data:Post[])=>{
      this.posts=data;
    })
  }
  ngOnInit(): void {
    this.getPosts();
  }


  postMessage(form: any) {

  }

  logout() {
    this.router.navigate(['/login']);

  }
}
