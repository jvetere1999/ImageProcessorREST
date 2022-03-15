import React, { Fragment } from 'react';
import "./style/App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import UploadImages from './components/image-upload.component';;
import PixelGrid from "react-pixel-grid";
import ColorPage from "./components/color-page.component";
import { Route } from 'react-router-dom';


function App() {
    return (
      <Router>
        <main>
          <nav>
            <ul>
              <li><Link to="/">Home</Link></li>
              <li><Link to="/upload">Upload</Link></li>
              <li><Link to={`/files/${name}`}>Images</Link></li>
            </ul>
          </nav>
        <Switch>
          <Route path="/" exact component={Home} />
          <Route path="/upload/:name" exact component={Upload} />
          <Route path="/files" exact component={Image} />
        </Switch>
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
const Image = ({match:{params:{name}}}) => (
  <Fragment>
    <h1>Image</h1>
    <ColorPage/>
  </Fragment>
);

