import http from "../http-common";

class UploadFilesService {
    upload(file, onUploadProgress) {
        let formData = new FormData();
        formData.append("file", file);
        return http.post("/upload", formData, {
            headers: { "Content-Type": "multipart/form-data"},
            onUploadProgress,
        });
    }
    getFiles() {
        return http.get("/files");
    }
    getPackage(_file) {
        let x = http.get(_file).then(response => response.data);
        console.log(x);
        return x;
    }
}
export default new UploadFilesService();