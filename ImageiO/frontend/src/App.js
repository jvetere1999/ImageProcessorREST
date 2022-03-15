import React, { Fragment } from 'react';
import { BrowserRouter as Router, Route, Link, Routes} from "react-router-dom";
import ColorPage from "./components/color-page.component";
import UploadImages from './components/image-upload.component';;
import http from "./http-common";
import UploadService from './service/upload-files.service';
import "./style/App.css";
import "bootstrap/dist/css/bootstrap.min.css";




function App() {
  const name = 'John Doe';
  return (
    <Router>
      <main>
        <nav>
          <ul>
            <li><Link to="/">Home</Link></li>
            <li><Link to="/upload">Upload</Link></li>
            {/* <li><Link to={`/files/${name}`}>Images</Link></li> */}
          </ul>
        </nav>
        <Routes>
          <Route path="/" exact element={<Home/>} />
          <Route path="/upload" element={<Upload />} />
          <Route path="/files/:name" element={<Image/>} />
        </Routes>
      </main>
    </Router>

    
    );
}
export default App;

const Home = () => (
  <Fragment>
    <h1>Home</h1>
  </Fragment>
);
const Upload = () => (
  <Fragment>
    <div className='container' style={{ width: "600px" }}>
      <div style={{ margin: "20px" }}>
        <h3>ImageProcessor</h3>
        <h4>Upload Files</h4>
      </div>
      <UploadImages/>
    </div>
  </Fragment>
);
const Image = (props) => (
  <Fragment>
    <ColorPage  props={props}/>
  </Fragment>
);
