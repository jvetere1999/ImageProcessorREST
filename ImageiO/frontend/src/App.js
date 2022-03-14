import React, { Component } from 'react';
import "./style/App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import UploadImages from './components/image-upload.component';
import ColorPage from './components/color-page.component';


export default class App extends Component {
  constructor(props) {
    super(props);

    this.state = {
      curremtComponent: 'grid',
    };
  }
  switchComponent(comp) {
    this.setState({
      curremtComponent: comp,
    })
  }
  getComponent(){
    let component;
    switch(this.state.curremtComponent){
      case 'upload':
        component = <UploadImages/>
        break;
      case 'grid':
        component = <ColorPage/>
        break;
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
        {this.getComponent()}
      </div>
      );
  }
  
}

