import { Button } from "@/components/ui/button"
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card"
import { about } from "@/data/content"
import { Github, MessageCircle } from "lucide-react"

export function AboutCard() {
  return (
    <Card className="h-60">
      <CardHeader>
        <CardTitle className="text-xl">{about.title}</CardTitle>
      </CardHeader>
      <CardContent className="space-y-4">
        <p className="text-muted-foreground leading-relaxed">{about.description}</p>
        <div className="flex space-x-3">
          <Button 
            variant="outline" 
            size="sm" 
            className="flex items-center space-x-2"
            onClick={() => window.open(about.social.telegram, '_blank')}
          >
            <MessageCircle className="h-4 w-4" />
            <span>Telegram</span>
          </Button>
          <Button 
            variant="outline" 
            size="sm" 
            className="flex items-center space-x-2"
            onClick={() => window.open(about.social.github, '_blank')}
          >
            <Github className="h-4 w-4" />
            <span>Github</span>
          </Button>
        </div>
      </CardContent>
    </Card>
  )
}