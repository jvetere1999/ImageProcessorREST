import React, { Component } from 'react';
import "./style/App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import UploadImages from './components/image-upload.component';
import ColorPage from './components/color-page.component';


export default class App extends Component {
  render(){
    return (
      <div className='container' style={{ width: "600px" }}>
        <div style={{ margin: "20px" }}>
          <h3>ImageProcessor</h3>
          <h4>Upload Files</h4>
        </div>
        <ColorPage/>
        <UploadImages/>
      </div>
      );
  }
  
}

