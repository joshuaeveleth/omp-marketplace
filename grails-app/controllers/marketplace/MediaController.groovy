package marketplace

class MediaController {

    static defaultAction = "show"

    def show = {
        def folder = grailsAttributes.getApplicationContext().getResource('/').getFile().toString() + '/media'
        def allFiles = FileUtil.mediaInfoFromDescriptor(folder)
        def noviceMap = [:]
        def expertMap = [:]
        def guideMap = [:]
        def slideshowMap = [:]

        def keys = allFiles.keySet() as String[]

        keys.each() { key ->
            def info = allFiles.get(key)

            switch (info[1].toLowerCase()) {
                case "novice":
                    noviceMap.put(key, info)
                    break
                case "expert":
                    expertMap.put(key, info)
                    break
                case "guide":
                    guideMap.put(key, info)
                    break
                case "slideshow":
                    slideshowMap.put(key, info)
                    break
            }
        }


        def modelData = [fileMap: allFiles, noviceMedia: noviceMap, expertMedia: expertMap,
            guideMedia: guideMap, slideshowMedia: slideshowMap]
    }
}
