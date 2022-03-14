import React, { Component } from 'react';
import "./style/App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import UploadFiles from './components/upload-files.component';
import UploadImages from './components/image-upload.component';
import { render } from '@testing-library/react';


export default class App extends Component {
  getComponent(){
    let component;
    switch(this.state.curremtComponent){
      case 'upload':
        component = <UploadFiles/>
        break;
      case 'grid':
        component = <ColorPage/>
        break;
      default:
        component = <UploadFiles/>
    }
    return component;
  }
  render(){
    return (
      <div className='container' style={{ width: "600px" }}>
        <div style={{ margin: "20px" }}>
          <h3>ImageProcessor</h3>
          <h4>Upload Files</h4>
        </div>
        {this.getComponent}
      </div>
      );
  }
  
}

