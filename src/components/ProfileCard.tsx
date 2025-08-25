import { Avatar, AvatarFallback, AvatarImage } from "@/components/ui/avatar"
import { Card, CardContent } from "@/components/ui/card"
import { profile } from "@/data/content"

export function ProfileCard() {
  return (
    <Card className="h-60">
      <CardContent className="flex items-center space-x-4 p-6">
        <Avatar className="h-16 w-16">
          <AvatarImage src={profile.avatar} alt={profile.name} />
          <AvatarFallback className="bg-primary/20 text-primary text-lg font-semibold">
            {profile.name.split(' ').map(n => n[0]).join('')}
          </AvatarFallback>
        </Avatar>
        <div className="flex-1">
          <h2 className="text-2xl font-bold text-primary mb-2">{profile.name}</h2>
          <p className="text-muted-foreground">{profile.description}</p>
        </div>
      </CardContent>
    </Card>
  )
}